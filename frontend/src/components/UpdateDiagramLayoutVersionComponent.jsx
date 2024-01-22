import React, { Component } from 'react'
import DiagramLayoutVersionService from '../services/DiagramLayoutVersionService';

class UpdateDiagramLayoutVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiagramLayoutVersion = this.updateDiagramLayoutVersion.bind(this);

    }

    componentDidMount(){
        DiagramLayoutVersionService.getDiagramLayoutVersionById(this.state.id).then( (res) =>{
            let diagramLayoutVersion = res.data;
            this.setState({
            });
        });
    }

    updateDiagramLayoutVersion = (e) => {
        e.preventDefault();
        let diagramLayoutVersion = {
            diagramLayoutVersionId: this.state.id,
        };
        console.log('diagramLayoutVersion => ' + JSON.stringify(diagramLayoutVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramLayoutVersionService.updateDiagramLayoutVersion(diagramLayoutVersion).then( res => {
            this.props.history.push('/diagramLayoutVersions');
        });
    }


    cancel(){
        this.props.history.push('/diagramLayoutVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiagramLayoutVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagramLayoutVersion}>Save</button>
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

export default UpdateDiagramLayoutVersionComponent
