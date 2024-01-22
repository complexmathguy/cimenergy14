import React, { Component } from 'react'
import ApparentPowerService from '../services/ApparentPowerService'

class ViewApparentPowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            apparentPower: {}
        }
    }

    componentDidMount(){
        ApparentPowerService.getApparentPowerById(this.state.id).then( res => {
            this.setState({apparentPower: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ApparentPower Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Multiplier:&emsp; </label>
                            <div> { this.state.apparentPower.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> Unit:&emsp; </label>
                            <div> { this.state.apparentPower.unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewApparentPowerComponent
