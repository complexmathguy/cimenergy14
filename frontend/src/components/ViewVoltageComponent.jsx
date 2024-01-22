import React, { Component } from 'react'
import VoltageService from '../services/VoltageService'

class ViewVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            voltage: {}
        }
    }

    componentDidMount(){
        VoltageService.getVoltageById(this.state.id).then( res => {
            this.setState({voltage: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Voltage Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Multiplier:&emsp; </label>
                            <div> { this.state.voltage.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> Unit:&emsp; </label>
                            <div> { this.state.voltage.unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVoltageComponent
