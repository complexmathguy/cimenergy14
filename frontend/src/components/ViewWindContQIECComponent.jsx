import React, { Component } from 'react'
import WindContQIECService from '../services/WindContQIECService'

class ViewWindContQIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContQIEC: {}
        }
    }

    componentDidMount(){
        WindContQIECService.getWindContQIECById(this.state.id).then( res => {
            this.setState({windContQIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContQIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> WindLVRTQcontrolModesType:&emsp; </label>
                            <div> { this.state.windContQIEC.windLVRTQcontrolModesType }</div>
                        </div>
                        <div className = "row">
                            <label> WindQcontrolModesType:&emsp; </label>
                            <div> { this.state.windContQIEC.windQcontrolModesType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContQIECComponent
