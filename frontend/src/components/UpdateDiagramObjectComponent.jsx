import React, { Component } from 'react'
import DiagramObjectService from '../services/DiagramObjectService';

class UpdateDiagramObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiagramObject = this.updateDiagramObject.bind(this);

    }

    componentDidMount(){
        DiagramObjectService.getDiagramObjectById(this.state.id).then( (res) =>{
            let diagramObject = res.data;
            this.setState({
            });
        });
    }

    updateDiagramObject = (e) => {
        e.preventDefault();
        let diagramObject = {
            diagramObjectId: this.state.id,
        };
        console.log('diagramObject => ' + JSON.stringify(diagramObject));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramObjectService.updateDiagramObject(diagramObject).then( res => {
            this.props.history.push('/diagramObjects');
        });
    }


    cancel(){
        this.props.history.push('/diagramObjects');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiagramObject</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagramObject}>Save</button>
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

export default UpdateDiagramObjectComponent
