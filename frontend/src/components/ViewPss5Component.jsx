import React, { Component } from 'react'
import Pss5Service from '../services/Pss5Service'

class ViewPss5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss5: {}
        }
    }

    componentDidMount(){
        Pss5Service.getPss5ById(this.state.id).then( res => {
            this.setState({pss5: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss5 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss5Component
