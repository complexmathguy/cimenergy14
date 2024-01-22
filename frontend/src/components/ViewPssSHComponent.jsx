import React, { Component } from 'react'
import PssSHService from '../services/PssSHService'

class ViewPssSHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssSH: {}
        }
    }

    componentDidMount(){
        PssSHService.getPssSHById(this.state.id).then( res => {
            this.setState({pssSH: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssSH Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssSHComponent
