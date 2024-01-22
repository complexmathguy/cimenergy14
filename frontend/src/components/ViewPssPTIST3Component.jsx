import React, { Component } from 'react'
import PssPTIST3Service from '../services/PssPTIST3Service'

class ViewPssPTIST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssPTIST3: {}
        }
    }

    componentDidMount(){
        PssPTIST3Service.getPssPTIST3ById(this.state.id).then( res => {
            this.setState({pssPTIST3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssPTIST3 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssPTIST3Component
