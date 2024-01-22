import React, { Component } from 'react'
import ExcIEEEDC3AService from '../services/ExcIEEEDC3AService';

class CreateExcIEEEDC3AComponent extends Component {
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
            ExcIEEEDC3AService.getExcIEEEDC3AById(this.state.id).then( (res) =>{
                let excIEEEDC3A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEDC3A = (e) => {
        e.preventDefault();
        let excIEEEDC3A = {
                excIEEEDC3AId: this.state.id,
            };
        console.log('excIEEEDC3A => ' + JSON.stringify(excIEEEDC3A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEDC3A.excIEEEDC3AId=''
            ExcIEEEDC3AService.createExcIEEEDC3A(excIEEEDC3A).then(res =>{
                this.props.history.push('/excIEEEDC3As');
            });
        }else{
            ExcIEEEDC3AService.updateExcIEEEDC3A(excIEEEDC3A).then( res => {
                this.props.history.push('/excIEEEDC3As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEDC3As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEDC3A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEDC3A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEDC3A}>Save</button>
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

export default CreateExcIEEEDC3AComponent
