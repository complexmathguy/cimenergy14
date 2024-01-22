import React, { Component } from 'react'
import PUService from '../services/PUService'

class ViewPUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pU: {}
        }
    }

    componentDidMount(){
        PUService.getPUById(this.state.id).then( res => {
            this.setState({pU: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PU Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Multiplier:&emsp; </label>
                            <div> { this.state.pU.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> Unit:&emsp; </label>
                            <div> { this.state.pU.unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPUComponent
