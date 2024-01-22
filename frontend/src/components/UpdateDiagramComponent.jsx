import React, { Component } from 'react'
import DiagramService from '../services/DiagramService';

class UpdateDiagramComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                orientation: ''
        }
        this.updateDiagram = this.updateDiagram.bind(this);

        this.changeOrientationHandler = this.changeOrientationHandler.bind(this);
    }

    componentDidMount(){
        DiagramService.getDiagramById(this.state.id).then( (res) =>{
            let diagram = res.data;
            this.setState({
                orientation: diagram.orientation
            });
        });
    }

    updateDiagram = (e) => {
        e.preventDefault();
        let diagram = {
            diagramId: this.state.id,
            orientation: this.state.orientation
        };
        console.log('diagram => ' + JSON.stringify(diagram));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramService.updateDiagram(diagram).then( res => {
            this.props.history.push('/diagrams');
        });
    }

    changeOrientationHandler= (event) => {
        this.setState({orientation: event.target.value});
    }

    cancel(){
        this.props.history.push('/diagrams');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Diagram</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Orientation: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagram}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateDiagramComponent
