import React, { Component } from 'react'
import AsynchronousMachineService from '../services/AsynchronousMachineService'

class ViewAsynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            asynchronousMachine: {}
        }
    }

    componentDidMount(){
        AsynchronousMachineService.getAsynchronousMachineById(this.state.id).then( res => {
            this.setState({asynchronousMachine: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AsynchronousMachine Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAsynchronousMachineComponent
