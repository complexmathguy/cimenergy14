import React, { Component } from 'react'
import SvVoltageService from '../services/SvVoltageService'

class ViewSvVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            svVoltage: {}
        }
    }

    componentDidMount(){
        SvVoltageService.getSvVoltageById(this.state.id).then( res => {
            this.setState({svVoltage: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SvVoltage Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSvVoltageComponent
