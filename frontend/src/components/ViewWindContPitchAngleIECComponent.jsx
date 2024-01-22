import React, { Component } from 'react'
import WindContPitchAngleIECService from '../services/WindContPitchAngleIECService'

class ViewWindContPitchAngleIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContPitchAngleIEC: {}
        }
    }

    componentDidMount(){
        WindContPitchAngleIECService.getWindContPitchAngleIECById(this.state.id).then( res => {
            this.setState({windContPitchAngleIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContPitchAngleIEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContPitchAngleIECComponent
