import React, { Component } from 'react'
import WindContRotorRIECService from '../services/WindContRotorRIECService'

class ViewWindContRotorRIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContRotorRIEC: {}
        }
    }

    componentDidMount(){
        WindContRotorRIECService.getWindContRotorRIECById(this.state.id).then( res => {
            this.setState({windContRotorRIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContRotorRIEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContRotorRIECComponent
