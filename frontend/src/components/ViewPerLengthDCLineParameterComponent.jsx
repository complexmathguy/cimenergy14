import React, { Component } from 'react'
import PerLengthDCLineParameterService from '../services/PerLengthDCLineParameterService'

class ViewPerLengthDCLineParameterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            perLengthDCLineParameter: {}
        }
    }

    componentDidMount(){
        PerLengthDCLineParameterService.getPerLengthDCLineParameterById(this.state.id).then( res => {
            this.setState({perLengthDCLineParameter: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PerLengthDCLineParameter Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPerLengthDCLineParameterComponent
