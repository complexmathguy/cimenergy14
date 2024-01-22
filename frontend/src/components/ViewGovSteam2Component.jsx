import React, { Component } from 'react'
import GovSteam2Service from '../services/GovSteam2Service'

class ViewGovSteam2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteam2: {}
        }
    }

    componentDidMount(){
        GovSteam2Service.getGovSteam2ById(this.state.id).then( res => {
            this.setState({govSteam2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteam2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteam2Component
