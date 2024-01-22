import React, { Component } from 'react'
import ConnectivityNodeService from '../services/ConnectivityNodeService'

class ViewConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            connectivityNode: {}
        }
    }

    componentDidMount(){
        ConnectivityNodeService.getConnectivityNodeById(this.state.id).then( res => {
            this.setState({connectivityNode: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ConnectivityNode Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConnectivityNodeComponent
