import React, { Component } from 'react'
import DiagramService from '../services/DiagramService'

class ViewDiagramComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagram: {}
        }
    }

    componentDidMount(){
        DiagramService.getDiagramById(this.state.id).then( res => {
            this.setState({diagram: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Diagram Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Orientation:&emsp; </label>
                            <div> { this.state.diagram.orientation }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramComponent
