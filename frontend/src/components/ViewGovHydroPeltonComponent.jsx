import React, { Component } from 'react'
import GovHydroPeltonService from '../services/GovHydroPeltonService'

class ViewGovHydroPeltonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroPelton: {}
        }
    }

    componentDidMount(){
        GovHydroPeltonService.getGovHydroPeltonById(this.state.id).then( res => {
            this.setState({govHydroPelton: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroPelton Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroPeltonComponent
