import React, { Component } from 'react'
import CsConverterService from '../services/CsConverterService'

class ViewCsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            csConverter: {}
        }
    }

    componentDidMount(){
        CsConverterService.getCsConverterById(this.state.id).then( res => {
            this.setState({csConverter: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View CsConverter Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCsConverterComponent
