import React, { Component } from 'react'
import GovHydroIEEE0Service from '../services/GovHydroIEEE0Service'

class ViewGovHydroIEEE0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroIEEE0: {}
        }
    }

    componentDidMount(){
        GovHydroIEEE0Service.getGovHydroIEEE0ById(this.state.id).then( res => {
            this.setState({govHydroIEEE0: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroIEEE0 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroIEEE0Component
