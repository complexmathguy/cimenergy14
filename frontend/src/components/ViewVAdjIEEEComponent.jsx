import React, { Component } from 'react'
import VAdjIEEEService from '../services/VAdjIEEEService'

class ViewVAdjIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            vAdjIEEE: {}
        }
    }

    componentDidMount(){
        VAdjIEEEService.getVAdjIEEEById(this.state.id).then( res => {
            this.setState({vAdjIEEE: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VAdjIEEE Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVAdjIEEEComponent
