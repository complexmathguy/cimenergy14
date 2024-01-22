import React, { Component } from 'react'
import DiagramService from '../services/DiagramService';

class CreateDiagramComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                orientation: ''
        }
        this.changeOrientationHandler = this.changeOrientationHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DiagramService.getDiagramById(this.state.id).then( (res) =>{
                let diagram = res.data;
                this.setState({
                    orientation: diagram.orientation
                });
            });
        }        
    }
    saveOrUpdateDiagram = (e) => {
        e.preventDefault();
        let diagram = {
                diagramId: this.state.id,
                orientation: this.state.orientation
            };
        console.log('diagram => ' + JSON.stringify(diagram));

        // step 5
        if(this.state.id === '_add'){
            diagram.diagramId=''
            DiagramService.createDiagram(diagram).then(res =>{
                this.props.history.push('/diagrams');
            });
        }else{
            DiagramService.updateDiagram(diagram).then( res => {
                this.props.history.push('/diagrams');
            });
        }
    }
    
    changeOrientationHandler= (event) => {
        this.setState({orientation: event.target.value});
    }

    cancel(){
        this.props.history.push('/diagrams');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Diagram</h3>
        }else{
            return <h3 className="text-center">Update Diagram</h3>
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
                                            <label> Orientation: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagram}>Save</button>
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

export default CreateDiagramComponent
