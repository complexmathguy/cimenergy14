import React, { Component } from 'react'
import WindPlantFreqPcontrolIECService from '../services/WindPlantFreqPcontrolIECService'

class ViewWindPlantFreqPcontrolIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windPlantFreqPcontrolIEC: {}
        }
    }

    componentDidMount(){
        WindPlantFreqPcontrolIECService.getWindPlantFreqPcontrolIECById(this.state.id).then( res => {
            this.setState({windPlantFreqPcontrolIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindPlantFreqPcontrolIEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindPlantFreqPcontrolIECComponent
