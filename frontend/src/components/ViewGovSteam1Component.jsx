import React, { Component } from 'react'
import GovSteam1Service from '../services/GovSteam1Service'

class ViewGovSteam1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govSteam1: {}
        }
    }

    componentDidMount(){
        GovSteam1Service.getGovSteam1ById(this.state.id).then( res => {
            this.setState({govSteam1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovSteam1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovSteam1Component
