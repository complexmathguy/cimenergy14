import React, { Component } from 'react'
import ShuntCompensatorService from '../services/ShuntCompensatorService'

class ViewShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            shuntCompensator: {}
        }
    }

    componentDidMount(){
        ShuntCompensatorService.getShuntCompensatorById(this.state.id).then( res => {
            this.setState({shuntCompensator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ShuntCompensator Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewShuntCompensatorComponent
