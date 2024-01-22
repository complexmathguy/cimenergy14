import React, { Component } from 'react'
import SynchronousMachineTimeConstantReactanceService from '../services/SynchronousMachineTimeConstantReactanceService'

class ViewSynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachineTimeConstantReactance: {}
        }
    }

    componentDidMount(){
        SynchronousMachineTimeConstantReactanceService.getSynchronousMachineTimeConstantReactanceById(this.state.id).then( res => {
            this.setState({synchronousMachineTimeConstantReactance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachineTimeConstantReactance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ModelType:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.modelType }</div>
                        </div>
                        <div className = "row">
                            <label> RotorType:&emsp; </label>
                            <div> { this.state.synchronousMachineTimeConstantReactance.rotorType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineTimeConstantReactanceComponent
