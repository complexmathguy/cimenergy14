import React, { Component } from 'react'
import AnalogControlService from '../services/AnalogControlService'

class ViewAnalogControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            analogControl: {}
        }
    }

    componentDidMount(){
        AnalogControlService.getAnalogControlById(this.state.id).then( res => {
            this.setState({analogControl: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AnalogControl Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAnalogControlComponent
