import React, { Component } from 'react'
import GovHydro1Service from '../services/GovHydro1Service'

class ViewGovHydro1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydro1: {}
        }
    }

    componentDidMount(){
        GovHydro1Service.getGovHydro1ById(this.state.id).then( res => {
            this.setState({govHydro1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydro1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydro1Component
