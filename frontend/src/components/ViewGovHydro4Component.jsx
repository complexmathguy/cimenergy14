import React, { Component } from 'react'
import GovHydro4Service from '../services/GovHydro4Service'

class ViewGovHydro4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydro4: {}
        }
    }

    componentDidMount(){
        GovHydro4Service.getGovHydro4ById(this.state.id).then( res => {
            this.setState({govHydro4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydro4 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydro4Component
