import React, { Component } from 'react'
import PssPTIST1Service from '../services/PssPTIST1Service'

class ViewPssPTIST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssPTIST1: {}
        }
    }

    componentDidMount(){
        PssPTIST1Service.getPssPTIST1ById(this.state.id).then( res => {
            this.setState({pssPTIST1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssPTIST1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssPTIST1Component
