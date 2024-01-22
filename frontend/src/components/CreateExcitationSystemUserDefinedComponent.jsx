import React, { Component } from 'react'
import ExcitationSystemUserDefinedService from '../services/ExcitationSystemUserDefinedService';

class CreateExcitationSystemUserDefinedComponent extends Component {
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
            ExcitationSystemUserDefinedService.getExcitationSystemUserDefinedById(this.state.id).then( (res) =>{
                let excitationSystemUserDefined = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcitationSystemUserDefined = (e) => {
        e.preventDefault();
        let excitationSystemUserDefined = {
                excitationSystemUserDefinedId: this.state.id,
            };
        console.log('excitationSystemUserDefined => ' + JSON.stringify(excitationSystemUserDefined));

        // step 5
        if(this.state.id === '_add'){
            excitationSystemUserDefined.excitationSystemUserDefinedId=''
            ExcitationSystemUserDefinedService.createExcitationSystemUserDefined(excitationSystemUserDefined).then(res =>{
                this.props.history.push('/excitationSystemUserDefineds');
            });
        }else{
            ExcitationSystemUserDefinedService.updateExcitationSystemUserDefined(excitationSystemUserDefined).then( res => {
                this.props.history.push('/excitationSystemUserDefineds');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excitationSystemUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcitationSystemUserDefined</h3>
        }else{
            return <h3 className="text-center">Update ExcitationSystemUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcitationSystemUserDefined}>Save</button>
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

export default CreateExcitationSystemUserDefinedComponent
