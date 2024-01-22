import React, { Component } from 'react'
import GovCT2Service from '../services/GovCT2Service'

class ViewGovCT2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govCT2: {}
        }
    }

    componentDidMount(){
        GovCT2Service.getGovCT2ById(this.state.id).then( res => {
            this.setState({govCT2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovCT2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Rselect:&emsp; </label>
                            <div> { this.state.govCT2.rselect }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovCT2Component
