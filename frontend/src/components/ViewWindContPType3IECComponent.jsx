import React, { Component } from 'react'
import WindContPType3IECService from '../services/WindContPType3IECService'

class ViewWindContPType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windContPType3IEC: {}
        }
    }

    componentDidMount(){
        WindContPType3IECService.getWindContPType3IECById(this.state.id).then( res => {
            this.setState({windContPType3IEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindContPType3IEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindContPType3IECComponent
