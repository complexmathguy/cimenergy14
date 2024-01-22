import React, { Component } from 'react'
import DCSeriesDeviceService from '../services/DCSeriesDeviceService'

class ViewDCSeriesDeviceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCSeriesDevice: {}
        }
    }

    componentDidMount(){
        DCSeriesDeviceService.getDCSeriesDeviceById(this.state.id).then( res => {
            this.setState({dCSeriesDevice: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCSeriesDevice Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCSeriesDeviceComponent
