import React, { Component } from 'react'
import GovHydroPID2Service from '../services/GovHydroPID2Service'

class ViewGovHydroPID2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroPID2: {}
        }
    }

    componentDidMount(){
        GovHydroPID2Service.getGovHydroPID2ById(this.state.id).then( res => {
            this.setState({govHydroPID2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroPID2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroPID2Component
