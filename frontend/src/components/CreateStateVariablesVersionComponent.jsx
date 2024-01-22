import React, { Component } from 'react'
import StateVariablesVersionService from '../services/StateVariablesVersionService';

class CreateStateVariablesVersionComponent extends Component {
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
            StateVariablesVersionService.getStateVariablesVersionById(this.state.id).then( (res) =>{
                let stateVariablesVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateStateVariablesVersion = (e) => {
        e.preventDefault();
        let stateVariablesVersion = {
                stateVariablesVersionId: this.state.id,
            };
        console.log('stateVariablesVersion => ' + JSON.stringify(stateVariablesVersion));

        // step 5
        if(this.state.id === '_add'){
            stateVariablesVersion.stateVariablesVersionId=''
            StateVariablesVersionService.createStateVariablesVersion(stateVariablesVersion).then(res =>{
                this.props.history.push('/stateVariablesVersions');
            });
        }else{
            StateVariablesVersionService.updateStateVariablesVersion(stateVariablesVersion).then( res => {
                this.props.history.push('/stateVariablesVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/stateVariablesVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add StateVariablesVersion</h3>
        }else{
            return <h3 className="text-center">Update StateVariablesVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateStateVariablesVersion}>Save</button>
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

export default CreateStateVariablesVersionComponent
