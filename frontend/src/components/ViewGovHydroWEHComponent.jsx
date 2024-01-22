import React, { Component } from 'react'
import GovHydroWEHService from '../services/GovHydroWEHService'

class ViewGovHydroWEHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroWEH: {}
        }
    }

    componentDidMount(){
        GovHydroWEHService.getGovHydroWEHById(this.state.id).then( res => {
            this.setState({govHydroWEH: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroWEH Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroWEHComponent
