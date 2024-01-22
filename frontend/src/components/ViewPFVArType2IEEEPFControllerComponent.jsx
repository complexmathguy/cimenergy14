import React, { Component } from 'react'
import PFVArType2IEEEPFControllerService from '../services/PFVArType2IEEEPFControllerService'

class ViewPFVArType2IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArType2IEEEPFController: {}
        }
    }

    componentDidMount(){
        PFVArType2IEEEPFControllerService.getPFVArType2IEEEPFControllerById(this.state.id).then( res => {
            this.setState({pFVArType2IEEEPFController: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArType2IEEEPFController Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArType2IEEEPFControllerComponent
