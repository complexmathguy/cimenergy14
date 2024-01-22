import React, { Component } from 'react'
import PFVArType1IEEEVArControllerService from '../services/PFVArType1IEEEVArControllerService'

class ViewPFVArType1IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArType1IEEEVArController: {}
        }
    }

    componentDidMount(){
        PFVArType1IEEEVArControllerService.getPFVArType1IEEEVArControllerById(this.state.id).then( res => {
            this.setState({pFVArType1IEEEVArController: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArType1IEEEVArController Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArType1IEEEVArControllerComponent
