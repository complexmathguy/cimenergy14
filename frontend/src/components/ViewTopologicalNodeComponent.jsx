import React, { Component } from 'react'
import TopologicalNodeService from '../services/TopologicalNodeService'

class ViewTopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            topologicalNode: {}
        }
    }

    componentDidMount(){
        TopologicalNodeService.getTopologicalNodeById(this.state.id).then( res => {
            this.setState({topologicalNode: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TopologicalNode Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTopologicalNodeComponent
