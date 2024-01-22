import React, { Component } from 'react'
import ExternalNetworkInjectionService from '../services/ExternalNetworkInjectionService'

class ViewExternalNetworkInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            externalNetworkInjection: {}
        }
    }

    componentDidMount(){
        ExternalNetworkInjectionService.getExternalNetworkInjectionById(this.state.id).then( res => {
            this.setState({externalNetworkInjection: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExternalNetworkInjection Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExternalNetworkInjectionComponent
