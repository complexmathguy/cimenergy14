import React, { Component } from 'react'
import GovSteamFV2Service from '../services/GovSteamFV2Service'

class ViewGovSteamFV2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamFV2: {}
        }
    }

    componentDidMount(){
        GovSteamFV2Service.getGovSteamFV2ById(this.state.id).then( res => {
            this.setState({govSteamFV2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamFV2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamFV2Component
