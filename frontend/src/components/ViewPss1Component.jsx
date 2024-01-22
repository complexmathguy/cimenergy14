import React, { Component } from 'react'
import Pss1Service from '../services/Pss1Service'

class ViewPss1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss1: {}
        }
    }

    componentDidMount(){
        Pss1Service.getPss1ById(this.state.id).then( res => {
            this.setState({pss1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss1Component
