import React, { Component } from 'react'
import GovSteamIEEE1Service from '../services/GovSteamIEEE1Service'

class ViewGovSteamIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteamIEEE1: {}
        }
    }

    componentDidMount(){
        GovSteamIEEE1Service.getGovSteamIEEE1ById(this.state.id).then( res => {
            this.setState({govSteamIEEE1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteamIEEE1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteamIEEE1Component
