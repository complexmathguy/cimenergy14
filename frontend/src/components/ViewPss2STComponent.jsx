import React, { Component } from 'react'
import Pss2STService from '../services/Pss2STService'

class ViewPss2STComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss2ST: {}
        }
    }

    componentDidMount(){
        Pss2STService.getPss2STById(this.state.id).then( res => {
            this.setState({pss2ST: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss2ST Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> InputSignal1Type:&emsp; </label>
                            <div> { this.state.pss2ST.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> InputSignal2Type:&emsp; </label>
                            <div> { this.state.pss2ST.inputSignal2Type }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss2STComponent
