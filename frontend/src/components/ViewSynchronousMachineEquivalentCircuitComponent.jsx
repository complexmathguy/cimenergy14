import React, { Component } from 'react'
import SynchronousMachineEquivalentCircuitService from '../services/SynchronousMachineEquivalentCircuitService'

class ViewSynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachineEquivalentCircuit: {}
        }
    }

    componentDidMount(){
        SynchronousMachineEquivalentCircuitService.getSynchronousMachineEquivalentCircuitById(this.state.id).then( res => {
            this.setState({synchronousMachineEquivalentCircuit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachineEquivalentCircuit Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineEquivalentCircuitComponent
