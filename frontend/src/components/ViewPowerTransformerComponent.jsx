import React, { Component } from 'react'
import PowerTransformerService from '../services/PowerTransformerService'

class ViewPowerTransformerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            powerTransformer: {}
        }
    }

    componentDidMount(){
        PowerTransformerService.getPowerTransformerById(this.state.id).then( res => {
            this.setState({powerTransformer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PowerTransformer Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPowerTransformerComponent
