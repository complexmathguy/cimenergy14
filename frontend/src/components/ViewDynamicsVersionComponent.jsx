import React, { Component } from 'react'
import DynamicsVersionService from '../services/DynamicsVersionService'

class ViewDynamicsVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dynamicsVersion: {}
        }
    }

    componentDidMount(){
        DynamicsVersionService.getDynamicsVersionById(this.state.id).then( res => {
            this.setState({dynamicsVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DynamicsVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDynamicsVersionComponent
