import React, { Component } from 'react'
import PowerTransformerEndService from '../services/PowerTransformerEndService'

class ViewPowerTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            powerTransformerEnd: {}
        }
    }

    componentDidMount(){
        PowerTransformerEndService.getPowerTransformerEndById(this.state.id).then( res => {
            this.setState({powerTransformerEnd: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PowerTransformerEnd Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ConnectionKind:&emsp; </label>
                            <div> { this.state.powerTransformerEnd.connectionKind }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPowerTransformerEndComponent
