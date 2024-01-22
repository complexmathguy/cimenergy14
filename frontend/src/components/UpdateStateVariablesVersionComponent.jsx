import React, { Component } from 'react'
import StateVariablesVersionService from '../services/StateVariablesVersionService';

class UpdateStateVariablesVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateStateVariablesVersion = this.updateStateVariablesVersion.bind(this);

    }

    componentDidMount(){
        StateVariablesVersionService.getStateVariablesVersionById(this.state.id).then( (res) =>{
            let stateVariablesVersion = res.data;
            this.setState({
            });
        });
    }

    updateStateVariablesVersion = (e) => {
        e.preventDefault();
        let stateVariablesVersion = {
            stateVariablesVersionId: this.state.id,
        };
        console.log('stateVariablesVersion => ' + JSON.stringify(stateVariablesVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        StateVariablesVersionService.updateStateVariablesVersion(stateVariablesVersion).then( res => {
            this.props.history.push('/stateVariablesVersions');
        });
    }


    cancel(){
        this.props.history.push('/stateVariablesVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update StateVariablesVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateStateVariablesVersion}>Save</button>
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

export default UpdateStateVariablesVersionComponent
