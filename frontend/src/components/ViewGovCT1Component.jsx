import React, { Component } from 'react'
import GovCT1Service from '../services/GovCT1Service'

class ViewGovCT1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govCT1: {}
        }
    }

    componentDidMount(){
        GovCT1Service.getGovCT1ById(this.state.id).then( res => {
            this.setState({govCT1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovCT1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Rselect:&emsp; </label>
                            <div> { this.state.govCT1.rselect }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovCT1Component
