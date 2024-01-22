import React, { Component } from 'react'
import SynchronousMachineEquivalentCircuitService from '../services/SynchronousMachineEquivalentCircuitService';

class CreateSynchronousMachineEquivalentCircuitComponent extends Component {
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
            SynchronousMachineEquivalentCircuitService.getSynchronousMachineEquivalentCircuitById(this.state.id).then( (res) =>{
                let synchronousMachineEquivalentCircuit = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSynchronousMachineEquivalentCircuit = (e) => {
        e.preventDefault();
        let synchronousMachineEquivalentCircuit = {
                synchronousMachineEquivalentCircuitId: this.state.id,
            };
        console.log('synchronousMachineEquivalentCircuit => ' + JSON.stringify(synchronousMachineEquivalentCircuit));

        // step 5
        if(this.state.id === '_add'){
            synchronousMachineEquivalentCircuit.synchronousMachineEquivalentCircuitId=''
            SynchronousMachineEquivalentCircuitService.createSynchronousMachineEquivalentCircuit(synchronousMachineEquivalentCircuit).then(res =>{
                this.props.history.push('/synchronousMachineEquivalentCircuits');
            });
        }else{
            SynchronousMachineEquivalentCircuitService.updateSynchronousMachineEquivalentCircuit(synchronousMachineEquivalentCircuit).then( res => {
                this.props.history.push('/synchronousMachineEquivalentCircuits');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/synchronousMachineEquivalentCircuits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachineEquivalentCircuit</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachineEquivalentCircuit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachineEquivalentCircuit}>Save</button>
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

export default CreateSynchronousMachineEquivalentCircuitComponent
