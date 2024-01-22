import React, { Component } from 'react'
import NonlinearShuntCompensatorPointService from '../services/NonlinearShuntCompensatorPointService'

class ViewNonlinearShuntCompensatorPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nonlinearShuntCompensatorPoint: {}
        }
    }

    componentDidMount(){
        NonlinearShuntCompensatorPointService.getNonlinearShuntCompensatorPointById(this.state.id).then( res => {
            this.setState({nonlinearShuntCompensatorPoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View NonlinearShuntCompensatorPoint Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewNonlinearShuntCompensatorPointComponent
