import React, { Component } from 'react'
import LoadMotorService from '../services/LoadMotorService'

class ViewLoadMotorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadMotor: {}
        }
    }

    componentDidMount(){
        LoadMotorService.getLoadMotorById(this.state.id).then( res => {
            this.setState({loadMotor: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadMotor Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadMotorComponent
