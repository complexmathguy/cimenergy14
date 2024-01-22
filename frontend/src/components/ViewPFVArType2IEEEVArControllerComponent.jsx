import React, { Component } from 'react'
import PFVArType2IEEEVArControllerService from '../services/PFVArType2IEEEVArControllerService'

class ViewPFVArType2IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArType2IEEEVArController: {}
        }
    }

    componentDidMount(){
        PFVArType2IEEEVArControllerService.getPFVArType2IEEEVArControllerById(this.state.id).then( res => {
            this.setState({pFVArType2IEEEVArController: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArType2IEEEVArController Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArType2IEEEVArControllerComponent
