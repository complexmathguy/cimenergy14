import React, { Component } from 'react'
import RotationSpeedService from '../services/RotationSpeedService'

class ViewRotationSpeedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            rotationSpeed: {}
        }
    }

    componentDidMount(){
        RotationSpeedService.getRotationSpeedById(this.state.id).then( res => {
            this.setState({rotationSpeed: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RotationSpeed Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> DenominatorMultiplier:&emsp; </label>
                            <div> { this.state.rotationSpeed.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> DenominatorUnit:&emsp; </label>
                            <div> { this.state.rotationSpeed.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> Multiplier:&emsp; </label>
                            <div> { this.state.rotationSpeed.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> Unit:&emsp; </label>
                            <div> { this.state.rotationSpeed.unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRotationSpeedComponent
