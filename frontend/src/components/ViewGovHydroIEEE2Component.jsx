import React, { Component } from 'react'
import GovHydroIEEE2Service from '../services/GovHydroIEEE2Service'

class ViewGovHydroIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroIEEE2: {}
        }
    }

    componentDidMount(){
        GovHydroIEEE2Service.getGovHydroIEEE2ById(this.state.id).then( res => {
            this.setState({govHydroIEEE2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroIEEE2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroIEEE2Component
