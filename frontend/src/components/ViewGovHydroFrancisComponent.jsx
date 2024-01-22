import React, { Component } from 'react'
import GovHydroFrancisService from '../services/GovHydroFrancisService'

class ViewGovHydroFrancisComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroFrancis: {}
        }
    }

    componentDidMount(){
        GovHydroFrancisService.getGovHydroFrancisById(this.state.id).then( res => {
            this.setState({govHydroFrancis: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroFrancis Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> GovernorControl:&emsp; </label>
                            <div> { this.state.govHydroFrancis.governorControl }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroFrancisComponent
