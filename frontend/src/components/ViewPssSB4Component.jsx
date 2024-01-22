import React, { Component } from 'react'
import PssSB4Service from '../services/PssSB4Service'

class ViewPssSB4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssSB4: {}
        }
    }

    componentDidMount(){
        PssSB4Service.getPssSB4ById(this.state.id).then( res => {
            this.setState({pssSB4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssSB4 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssSB4Component
