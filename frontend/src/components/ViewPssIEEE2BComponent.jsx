import React, { Component } from 'react'
import PssIEEE2BService from '../services/PssIEEE2BService'

class ViewPssIEEE2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssIEEE2B: {}
        }
    }

    componentDidMount(){
        PssIEEE2BService.getPssIEEE2BById(this.state.id).then( res => {
            this.setState({pssIEEE2B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssIEEE2B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> InputSignal1Type:&emsp; </label>
                            <div> { this.state.pssIEEE2B.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> InputSignal2Type:&emsp; </label>
                            <div> { this.state.pssIEEE2B.inputSignal2Type }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssIEEE2BComponent
