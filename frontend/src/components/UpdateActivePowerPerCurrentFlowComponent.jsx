import React, { Component } from 'react'
import ActivePowerPerCurrentFlowService from '../services/ActivePowerPerCurrentFlowService';

class UpdateActivePowerPerCurrentFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateActivePowerPerCurrentFlow = this.updateActivePowerPerCurrentFlow.bind(this);

    }

    componentDidMount(){
        ActivePowerPerCurrentFlowService.getActivePowerPerCurrentFlowById(this.state.id).then( (res) =>{
            let activePowerPerCurrentFlow = res.data;
            this.setState({
            });
        });
    }

    updateActivePowerPerCurrentFlow = (e) => {
        e.preventDefault();
        let activePowerPerCurrentFlow = {
            activePowerPerCurrentFlowId: this.state.id,
        };
        console.log('activePowerPerCurrentFlow => ' + JSON.stringify(activePowerPerCurrentFlow));
        console.log('id => ' + JSON.stringify(this.state.id));
        ActivePowerPerCurrentFlowService.updateActivePowerPerCurrentFlow(activePowerPerCurrentFlow).then( res => {
            this.props.history.push('/activePowerPerCurrentFlows');
        });
    }


    cancel(){
        this.props.history.push('/activePowerPerCurrentFlows');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ActivePowerPerCurrentFlow</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateActivePowerPerCurrentFlow}>Save</button>
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

export default UpdateActivePowerPerCurrentFlowComponent
