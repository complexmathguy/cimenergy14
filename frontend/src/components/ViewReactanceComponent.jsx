import React, { Component } from 'react'
import ReactanceService from '../services/ReactanceService'

class ViewReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            reactance: {}
        }
    }

    componentDidMount(){
        ReactanceService.getReactanceById(this.state.id).then( res => {
            this.setState({reactance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Reactance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Multiplier:&emsp; </label>
                            <div> { this.state.reactance.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> Unit:&emsp; </label>
                            <div> { this.state.reactance.unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewReactanceComponent
