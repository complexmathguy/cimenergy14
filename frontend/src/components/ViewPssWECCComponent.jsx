import React, { Component } from 'react'
import PssWECCService from '../services/PssWECCService'

class ViewPssWECCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssWECC: {}
        }
    }

    componentDidMount(){
        PssWECCService.getPssWECCById(this.state.id).then( res => {
            this.setState({pssWECC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssWECC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> InputSignal1Type:&emsp; </label>
                            <div> { this.state.pssWECC.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> InputSignal2Type:&emsp; </label>
                            <div> { this.state.pssWECC.inputSignal2Type }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssWECCComponent
