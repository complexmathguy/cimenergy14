import React, { Component } from 'react'
import TopologyVersionService from '../services/TopologyVersionService'

class ViewTopologyVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            topologyVersion: {}
        }
    }

    componentDidMount(){
        TopologyVersionService.getTopologyVersionById(this.state.id).then( res => {
            this.setState({topologyVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TopologyVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTopologyVersionComponent
