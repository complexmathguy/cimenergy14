import React, { Component } from 'react'
import DiagramLayoutVersionService from '../services/DiagramLayoutVersionService';

class CreateDiagramLayoutVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DiagramLayoutVersionService.getDiagramLayoutVersionById(this.state.id).then( (res) =>{
                let diagramLayoutVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiagramLayoutVersion = (e) => {
        e.preventDefault();
        let diagramLayoutVersion = {
                diagramLayoutVersionId: this.state.id,
            };
        console.log('diagramLayoutVersion => ' + JSON.stringify(diagramLayoutVersion));

        // step 5
        if(this.state.id === '_add'){
            diagramLayoutVersion.diagramLayoutVersionId=''
            DiagramLayoutVersionService.createDiagramLayoutVersion(diagramLayoutVersion).then(res =>{
                this.props.history.push('/diagramLayoutVersions');
            });
        }else{
            DiagramLayoutVersionService.updateDiagramLayoutVersion(diagramLayoutVersion).then( res => {
                this.props.history.push('/diagramLayoutVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/diagramLayoutVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramLayoutVersion</h3>
        }else{
            return <h3 className="text-center">Update DiagramLayoutVersion</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramLayoutVersion}>Save</button>
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

export default CreateDiagramLayoutVersionComponent
