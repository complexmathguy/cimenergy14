import React, { Component } from 'react'
import GovSteamSGOService from '../services/GovSteamSGOService'

class ViewGovSteamSGOComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamSGO: {}
        }
    }

    componentDidMount(){
        GovSteamSGOService.getGovSteamSGOById(this.state.id).then( res => {
            this.setState({govSteamSGO: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamSGO Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamSGOComponent
