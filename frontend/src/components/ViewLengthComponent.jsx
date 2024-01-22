import React, { Component } from 'react'
import LengthService from '../services/LengthService'

class ViewLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            length: {}
        }
    }

    componentDidMount(){
        LengthService.getLengthById(this.state.id).then( res => {
            this.setState({length: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Length Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Multiplier:&emsp; </label>
                            <div> { this.state.length.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> Unit:&emsp; </label>
                            <div> { this.state.length.unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLengthComponent
