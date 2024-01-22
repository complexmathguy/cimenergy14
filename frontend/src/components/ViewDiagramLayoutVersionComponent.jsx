import React, { Component } from 'react'
import DiagramLayoutVersionService from '../services/DiagramLayoutVersionService'

class ViewDiagramLayoutVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagramLayoutVersion: {}
        }
    }

    componentDidMount(){
        DiagramLayoutVersionService.getDiagramLayoutVersionById(this.state.id).then( res => {
            this.setState({diagramLayoutVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiagramLayoutVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramLayoutVersionComponent
