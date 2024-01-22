import React, { Component } from 'react'
import GovHydroPIDService from '../services/GovHydroPIDService'

class ViewGovHydroPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroPID: {}
        }
    }

    componentDidMount(){
        GovHydroPIDService.getGovHydroPIDById(this.state.id).then( res => {
            this.setState({govHydroPID: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroPID Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroPIDComponent
