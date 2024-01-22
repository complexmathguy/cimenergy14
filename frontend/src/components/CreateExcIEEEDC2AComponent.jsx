import React, { Component } from 'react'
import ExcIEEEDC2AService from '../services/ExcIEEEDC2AService';

class CreateExcIEEEDC2AComponent extends Component {
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
            ExcIEEEDC2AService.getExcIEEEDC2AById(this.state.id).then( (res) =>{
                let excIEEEDC2A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEDC2A = (e) => {
        e.preventDefault();
        let excIEEEDC2A = {
                excIEEEDC2AId: this.state.id,
            };
        console.log('excIEEEDC2A => ' + JSON.stringify(excIEEEDC2A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEDC2A.excIEEEDC2AId=''
            ExcIEEEDC2AService.createExcIEEEDC2A(excIEEEDC2A).then(res =>{
                this.props.history.push('/excIEEEDC2As');
            });
        }else{
            ExcIEEEDC2AService.updateExcIEEEDC2A(excIEEEDC2A).then( res => {
                this.props.history.push('/excIEEEDC2As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEDC2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEDC2A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEDC2A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEDC2A}>Save</button>
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

export default CreateExcIEEEDC2AComponent
