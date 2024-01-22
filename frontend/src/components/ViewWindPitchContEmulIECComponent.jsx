import React, { Component } from 'react'
import WindPitchContEmulIECService from '../services/WindPitchContEmulIECService'

class ViewWindPitchContEmulIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windPitchContEmulIEC: {}
        }
    }

    componentDidMount(){
        WindPitchContEmulIECService.getWindPitchContEmulIECById(this.state.id).then( res => {
            this.setState({windPitchContEmulIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindPitchContEmulIEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindPitchContEmulIECComponent
