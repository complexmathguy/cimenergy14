import React, { Component } from 'react'
import SynchronousMachineEquivalentCircuitService from '../services/SynchronousMachineEquivalentCircuitService';

class UpdateSynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSynchronousMachineEquivalentCircuit = this.updateSynchronousMachineEquivalentCircuit.bind(this);

    }

    componentDidMount(){
        SynchronousMachineEquivalentCircuitService.getSynchronousMachineEquivalentCircuitById(this.state.id).then( (res) =>{
            let synchronousMachineEquivalentCircuit = res.data;
            this.setState({
            });
        });
    }

    updateSynchronousMachineEquivalentCircuit = (e) => {
        e.preventDefault();
        let synchronousMachineEquivalentCircuit = {
            synchronousMachineEquivalentCircuitId: this.state.id,
        };
        console.log('synchronousMachineEquivalentCircuit => ' + JSON.stringify(synchronousMachineEquivalentCircuit));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineEquivalentCircuitService.updateSynchronousMachineEquivalentCircuit(synchronousMachineEquivalentCircuit).then( res => {
            this.props.history.push('/synchronousMachineEquivalentCircuits');
        });
    }


    cancel(){
        this.props.history.push('/synchronousMachineEquivalentCircuits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineEquivalentCircuit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineEquivalentCircuit}>Save</button>
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

export default UpdateSynchronousMachineEquivalentCircuitComponent
