import React, { Component } from 'react'
import DiagramObjectPointService from '../services/DiagramObjectPointService'

class ViewDiagramObjectPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagramObjectPoint: {}
        }
    }

    componentDidMount(){
        DiagramObjectPointService.getDiagramObjectPointById(this.state.id).then( res => {
            this.setState({diagramObjectPoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiagramObjectPoint Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramObjectPointComponent
