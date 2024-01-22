import React, { Component } from 'react'
import LoadResponseCharacteristicService from '../services/LoadResponseCharacteristicService'

class ViewLoadResponseCharacteristicComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadResponseCharacteristic: {}
        }
    }

    componentDidMount(){
        LoadResponseCharacteristicService.getLoadResponseCharacteristicById(this.state.id).then( res => {
            this.setState({loadResponseCharacteristic: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadResponseCharacteristic Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadResponseCharacteristicComponent
