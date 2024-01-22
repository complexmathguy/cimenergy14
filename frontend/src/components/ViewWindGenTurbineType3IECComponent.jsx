import React, { Component } from 'react'
import WindGenTurbineType3IECService from '../services/WindGenTurbineType3IECService'

class ViewWindGenTurbineType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windGenTurbineType3IEC: {}
        }
    }

    componentDidMount(){
        WindGenTurbineType3IECService.getWindGenTurbineType3IECById(this.state.id).then( res => {
            this.setState({windGenTurbineType3IEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindGenTurbineType3IEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindGenTurbineType3IECComponent
