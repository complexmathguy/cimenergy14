import React, { Component } from 'react'
import AsynchronousMachineEquivalentCircuitService from '../services/AsynchronousMachineEquivalentCircuitService';

class CreateAsynchronousMachineEquivalentCircuitComponent extends Component {
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
            AsynchronousMachineEquivalentCircuitService.getAsynchronousMachineEquivalentCircuitById(this.state.id).then( (res) =>{
                let asynchronousMachineEquivalentCircuit = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAsynchronousMachineEquivalentCircuit = (e) => {
        e.preventDefault();
        let asynchronousMachineEquivalentCircuit = {
                asynchronousMachineEquivalentCircuitId: this.state.id,
            };
        console.log('asynchronousMachineEquivalentCircuit => ' + JSON.stringify(asynchronousMachineEquivalentCircuit));

        // step 5
        if(this.state.id === '_add'){
            asynchronousMachineEquivalentCircuit.asynchronousMachineEquivalentCircuitId=''
            AsynchronousMachineEquivalentCircuitService.createAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit).then(res =>{
                this.props.history.push('/asynchronousMachineEquivalentCircuits');
            });
        }else{
            AsynchronousMachineEquivalentCircuitService.updateAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit).then( res => {
                this.props.history.push('/asynchronousMachineEquivalentCircuits');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/asynchronousMachineEquivalentCircuits');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AsynchronousMachineEquivalentCircuit</h3>
        }else{
            return <h3 className="text-center">Update AsynchronousMachineEquivalentCircuit</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAsynchronousMachineEquivalentCircuit}>Save</button>
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

export default CreateAsynchronousMachineEquivalentCircuitComponent
