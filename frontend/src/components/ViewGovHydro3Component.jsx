import React, { Component } from 'react'
import GovHydro3Service from '../services/GovHydro3Service'

class ViewGovHydro3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydro3: {}
        }
    }

    componentDidMount(){
        GovHydro3Service.getGovHydro3ById(this.state.id).then( res => {
            this.setState({govHydro3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydro3 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydro3Component
