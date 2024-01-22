import React, { Component } from 'react'
import PFVArType2Common1Service from '../services/PFVArType2Common1Service'

class ViewPFVArType2Common1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArType2Common1: {}
        }
    }

    componentDidMount(){
        PFVArType2Common1Service.getPFVArType2Common1ById(this.state.id).then( res => {
            this.setState({pFVArType2Common1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArType2Common1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArType2Common1Component
