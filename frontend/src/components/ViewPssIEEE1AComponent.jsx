import React, { Component } from 'react'
import PssIEEE1AService from '../services/PssIEEE1AService'

class ViewPssIEEE1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssIEEE1A: {}
        }
    }

    componentDidMount(){
        PssIEEE1AService.getPssIEEE1AById(this.state.id).then( res => {
            this.setState({pssIEEE1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssIEEE1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> InputSignalType:&emsp; </label>
                            <div> { this.state.pssIEEE1A.inputSignalType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssIEEE1AComponent
