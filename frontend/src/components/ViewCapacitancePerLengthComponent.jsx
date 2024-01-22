import React, { Component } from 'react'
import CapacitancePerLengthService from '../services/CapacitancePerLengthService'

class ViewCapacitancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            capacitancePerLength: {}
        }
    }

    componentDidMount(){
        CapacitancePerLengthService.getCapacitancePerLengthById(this.state.id).then( res => {
            this.setState({capacitancePerLength: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View CapacitancePerLength Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> DenominatorMultiplier:&emsp; </label>
                            <div> { this.state.capacitancePerLength.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> DenominatorUnit:&emsp; </label>
                            <div> { this.state.capacitancePerLength.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> Multiplier:&emsp; </label>
                            <div> { this.state.capacitancePerLength.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> Unit:&emsp; </label>
                            <div> { this.state.capacitancePerLength.unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCapacitancePerLengthComponent
