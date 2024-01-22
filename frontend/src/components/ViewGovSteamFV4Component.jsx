import React, { Component } from 'react'
import GovSteamFV4Service from '../services/GovSteamFV4Service'

class ViewGovSteamFV4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamFV4: {}
        }
    }

    componentDidMount(){
        GovSteamFV4Service.getGovSteamFV4ById(this.state.id).then( res => {
            this.setState({govSteamFV4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamFV4 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamFV4Component
