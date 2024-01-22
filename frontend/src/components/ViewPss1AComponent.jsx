import React, { Component } from 'react'
import Pss1AService from '../services/Pss1AService'

class ViewPss1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss1A: {}
        }
    }

    componentDidMount(){
        Pss1AService.getPss1AById(this.state.id).then( res => {
            this.setState({pss1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> InputSignalType:&emsp; </label>
                            <div> { this.state.pss1A.inputSignalType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss1AComponent
