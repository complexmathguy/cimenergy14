import React, { Component } from 'react'
import GovHydroDDService from '../services/GovHydroDDService'

class ViewGovHydroDDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroDD: {}
        }
    }

    componentDidMount(){
        GovHydroDDService.getGovHydroDDById(this.state.id).then( res => {
            this.setState({govHydroDD: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroDD Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroDDComponent
