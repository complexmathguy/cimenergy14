import React, { Component } from 'react'
import GovSteam0Service from '../services/GovSteam0Service'

class ViewGovSteam0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteam0: {}
        }
    }

    componentDidMount(){
        GovSteam0Service.getGovSteam0ById(this.state.id).then( res => {
            this.setState({govSteam0: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteam0 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteam0Component
