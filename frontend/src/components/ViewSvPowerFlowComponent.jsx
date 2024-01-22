import React, { Component } from 'react'
import SvPowerFlowService from '../services/SvPowerFlowService'

class ViewSvPowerFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            svPowerFlow: {}
        }
    }

    componentDidMount(){
        SvPowerFlowService.getSvPowerFlowById(this.state.id).then( res => {
            this.setState({svPowerFlow: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SvPowerFlow Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSvPowerFlowComponent
