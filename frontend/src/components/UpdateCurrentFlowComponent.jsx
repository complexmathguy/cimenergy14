import React, { Component } from 'react'
import CurrentFlowService from '../services/CurrentFlowService';

class UpdateCurrentFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateCurrentFlow = this.updateCurrentFlow.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        CurrentFlowService.getCurrentFlowById(this.state.id).then( (res) =>{
            let currentFlow = res.data;
            this.setState({
                multiplier: currentFlow.multiplier,
                unit: currentFlow.unit
            });
        });
    }

    updateCurrentFlow = (e) => {
        e.preventDefault();
        let currentFlow = {
            currentFlowId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('currentFlow => ' + JSON.stringify(currentFlow));
        console.log('id => ' + JSON.stringify(this.state.id));
        CurrentFlowService.updateCurrentFlow(currentFlow).then( res => {
            this.props.history.push('/currentFlows');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/currentFlows');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update CurrentFlow</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateCurrentFlow}>Save</button>
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

export default UpdateCurrentFlowComponent
