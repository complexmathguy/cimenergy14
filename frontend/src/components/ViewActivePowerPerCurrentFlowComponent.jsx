import React, { Component } from 'react'
import ActivePowerPerCurrentFlowService from '../services/ActivePowerPerCurrentFlowService'

class ViewActivePowerPerCurrentFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            activePowerPerCurrentFlow: {}
        }
    }

    componentDidMount(){
        ActivePowerPerCurrentFlowService.getActivePowerPerCurrentFlowById(this.state.id).then( res => {
            this.setState({activePowerPerCurrentFlow: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ActivePowerPerCurrentFlow Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewActivePowerPerCurrentFlowComponent
