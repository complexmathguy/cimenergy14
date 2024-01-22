import React, { Component } from 'react'
import GovHydro2Service from '../services/GovHydro2Service'

class ViewGovHydro2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydro2: {}
        }
    }

    componentDidMount(){
        GovHydro2Service.getGovHydro2ById(this.state.id).then( res => {
            this.setState({govHydro2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydro2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydro2Component
