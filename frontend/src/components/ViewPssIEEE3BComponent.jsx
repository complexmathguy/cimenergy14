import React, { Component } from 'react'
import PssIEEE3BService from '../services/PssIEEE3BService'

class ViewPssIEEE3BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssIEEE3B: {}
        }
    }

    componentDidMount(){
        PssIEEE3BService.getPssIEEE3BById(this.state.id).then( res => {
            this.setState({pssIEEE3B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssIEEE3B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> InputSignal1Type:&emsp; </label>
                            <div> { this.state.pssIEEE3B.inputSignal1Type }</div>
                        </div>
                        <div className = "row">
                            <label> InputSignal2Type:&emsp; </label>
                            <div> { this.state.pssIEEE3B.inputSignal2Type }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssIEEE3BComponent
