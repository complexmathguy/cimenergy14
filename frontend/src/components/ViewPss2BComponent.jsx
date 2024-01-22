import React, { Component } from 'react'
import Pss2BService from '../services/Pss2BService'

class ViewPss2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss2B: {}
        }
    }

    componentDidMount(){
        Pss2BService.getPss2BById(this.state.id).then( res => {
            this.setState({pss2B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss2B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> InputSignal1Type:&emsp; </label>
                            <div> { this.state.pss2B.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> InputSignal2Type:&emsp; </label>
                            <div> { this.state.pss2B.inputSignal2Type }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss2BComponent
