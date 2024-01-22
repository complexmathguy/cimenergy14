import React, { Component } from 'react'
import AsynchronousMachineTimeConstantReactanceService from '../services/AsynchronousMachineTimeConstantReactanceService'

class ViewAsynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            asynchronousMachineTimeConstantReactance: {}
        }
    }

    componentDidMount(){
        AsynchronousMachineTimeConstantReactanceService.getAsynchronousMachineTimeConstantReactanceById(this.state.id).then( res => {
            this.setState({asynchronousMachineTimeConstantReactance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AsynchronousMachineTimeConstantReactance Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAsynchronousMachineTimeConstantReactanceComponent
