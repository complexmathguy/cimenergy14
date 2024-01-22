import React, { Component } from 'react'
import PssSKService from '../services/PssSKService'

class ViewPssSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssSK: {}
        }
    }

    componentDidMount(){
        PssSKService.getPssSKById(this.state.id).then( res => {
            this.setState({pssSK: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssSK Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssSKComponent
