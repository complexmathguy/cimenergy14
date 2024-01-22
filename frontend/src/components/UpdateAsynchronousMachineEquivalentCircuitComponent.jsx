import React, { Component } from 'react'
import AsynchronousMachineEquivalentCircuitService from '../services/AsynchronousMachineEquivalentCircuitService';

class UpdateAsynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAsynchronousMachineEquivalentCircuit = this.updateAsynchronousMachineEquivalentCircuit.bind(this);

    }

    componentDidMount(){
        AsynchronousMachineEquivalentCircuitService.getAsynchronousMachineEquivalentCircuitById(this.state.id).then( (res) =>{
            let asynchronousMachineEquivalentCircuit = res.data;
            this.setState({
            });
        });
    }

    updateAsynchronousMachineEquivalentCircuit = (e) => {
        e.preventDefault();
        let asynchronousMachineEquivalentCircuit = {
            asynchronousMachineEquivalentCircuitId: this.state.id,
        };
        console.log('asynchronousMachineEquivalentCircuit => ' + JSON.stringify(asynchronousMachineEquivalentCircuit));
        console.log('id => ' + JSON.stringify(this.state.id));
        AsynchronousMachineEquivalentCircuitService.updateAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit).then( res => {
            this.props.history.push('/asynchronousMachineEquivalentCircuits');
        });
    }


    cancel(){
        this.props.history.push('/asynchronousMachineEquivalentCircuits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AsynchronousMachineEquivalentCircuit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAsynchronousMachineEquivalentCircuit}>Save</button>
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

export default UpdateAsynchronousMachineEquivalentCircuitComponent
