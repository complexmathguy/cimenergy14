import React, { Component } from 'react'
import SynchronousMachineService from '../services/SynchronousMachineService'

class ViewSynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachine: {}
        }
    }

    componentDidMount(){
        SynchronousMachineService.getSynchronousMachineById(this.state.id).then( res => {
            this.setState({synchronousMachine: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachine Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ShortCircuitRotorType:&emsp; </label>
                            <div> { this.state.synchronousMachine.shortCircuitRotorType }</div>
                        </div>
                        <div className = "row">
                            <label> Type:&emsp; </label>
                            <div> { this.state.synchronousMachine.type }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineComponent
