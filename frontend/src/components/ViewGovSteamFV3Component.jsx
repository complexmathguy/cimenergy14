import React, { Component } from 'react'
import GovSteamFV3Service from '../services/GovSteamFV3Service'

class ViewGovSteamFV3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamFV3: {}
        }
    }

    componentDidMount(){
        GovSteamFV3Service.getGovSteamFV3ById(this.state.id).then( res => {
            this.setState({govSteamFV3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamFV3 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamFV3Component
