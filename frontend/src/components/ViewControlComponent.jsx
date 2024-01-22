import React, { Component } from 'react'
import ControlService from '../services/ControlService'

class ViewControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            control: {}
        }
    }

    componentDidMount(){
        ControlService.getControlById(this.state.id).then( res => {
            this.setState({control: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Control Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> UnitMultiplier:&emsp; </label>
                            <div> { this.state.control.unitMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> UnitSymbol:&emsp; </label>
                            <div> { this.state.control.unitSymbol }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewControlComponent
