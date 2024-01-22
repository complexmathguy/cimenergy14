import React, { Component } from 'react'
import TopologyBoundaryVersionService from '../services/TopologyBoundaryVersionService'

class ViewTopologyBoundaryVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            topologyBoundaryVersion: {}
        }
    }

    componentDidMount(){
        TopologyBoundaryVersionService.getTopologyBoundaryVersionById(this.state.id).then( res => {
            this.setState({topologyBoundaryVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TopologyBoundaryVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTopologyBoundaryVersionComponent
