import React, { Component } from 'react'
import PFVArType1IEEEPFControllerService from '../services/PFVArType1IEEEPFControllerService'

class ViewPFVArType1IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArType1IEEEPFController: {}
        }
    }

    componentDidMount(){
        PFVArType1IEEEPFControllerService.getPFVArType1IEEEPFControllerById(this.state.id).then( res => {
            this.setState({pFVArType1IEEEPFController: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArType1IEEEPFController Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArType1IEEEPFControllerComponent
