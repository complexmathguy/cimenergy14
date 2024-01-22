import React, { Component } from 'react'
import ACDCConverterService from '../services/ACDCConverterService'

class ViewACDCConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            aCDCConverter: {}
        }
    }

    componentDidMount(){
        ACDCConverterService.getACDCConverterById(this.state.id).then( res => {
            this.setState({aCDCConverter: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ACDCConverter Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewACDCConverterComponent
