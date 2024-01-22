import React, { Component } from 'react'
import PetersenCoilService from '../services/PetersenCoilService'

class ViewPetersenCoilComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            petersenCoil: {}
        }
    }

    componentDidMount(){
        PetersenCoilService.getPetersenCoilById(this.state.id).then( res => {
            this.setState({petersenCoil: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PetersenCoil Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Mode:&emsp; </label>
                            <div> { this.state.petersenCoil.mode }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPetersenCoilComponent
