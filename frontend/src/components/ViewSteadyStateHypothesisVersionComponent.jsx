import React, { Component } from 'react'
import SteadyStateHypothesisVersionService from '../services/SteadyStateHypothesisVersionService'

class ViewSteadyStateHypothesisVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            steadyStateHypothesisVersion: {}
        }
    }

    componentDidMount(){
        SteadyStateHypothesisVersionService.getSteadyStateHypothesisVersionById(this.state.id).then( res => {
            this.setState({steadyStateHypothesisVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SteadyStateHypothesisVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSteadyStateHypothesisVersionComponent
