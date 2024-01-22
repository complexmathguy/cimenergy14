import React, { Component } from 'react'
import LinearShuntCompensatorService from '../services/LinearShuntCompensatorService'

class ViewLinearShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            linearShuntCompensator: {}
        }
    }

    componentDidMount(){
        LinearShuntCompensatorService.getLinearShuntCompensatorById(this.state.id).then( res => {
            this.setState({linearShuntCompensator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LinearShuntCompensator Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLinearShuntCompensatorComponent
