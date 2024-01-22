import React, { Component } from 'react'
import ExcIEEEDC1AService from '../services/ExcIEEEDC1AService';

class CreateExcIEEEDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEDC1AService.getExcIEEEDC1AById(this.state.id).then( (res) =>{
                let excIEEEDC1A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEDC1A = (e) => {
        e.preventDefault();
        let excIEEEDC1A = {
                excIEEEDC1AId: this.state.id,
            };
        console.log('excIEEEDC1A => ' + JSON.stringify(excIEEEDC1A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEDC1A.excIEEEDC1AId=''
            ExcIEEEDC1AService.createExcIEEEDC1A(excIEEEDC1A).then(res =>{
                this.props.history.push('/excIEEEDC1As');
            });
        }else{
            ExcIEEEDC1AService.updateExcIEEEDC1A(excIEEEDC1A).then( res => {
                this.props.history.push('/excIEEEDC1As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEDC1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEDC1A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEDC1A</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEDC1A}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateExcIEEEDC1AComponent
