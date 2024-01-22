import React, { Component } from 'react'
import DiagramObjectService from '../services/DiagramObjectService';

class CreateDiagramObjectComponent extends Component {
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
            DiagramObjectService.getDiagramObjectById(this.state.id).then( (res) =>{
                let diagramObject = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiagramObject = (e) => {
        e.preventDefault();
        let diagramObject = {
                diagramObjectId: this.state.id,
            };
        console.log('diagramObject => ' + JSON.stringify(diagramObject));

        // step 5
        if(this.state.id === '_add'){
            diagramObject.diagramObjectId=''
            DiagramObjectService.createDiagramObject(diagramObject).then(res =>{
                this.props.history.push('/diagramObjects');
            });
        }else{
            DiagramObjectService.updateDiagramObject(diagramObject).then( res => {
                this.props.history.push('/diagramObjects');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/diagramObjects');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramObject</h3>
        }else{
            return <h3 className="text-center">Update DiagramObject</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramObject}>Save</button>
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

export default CreateDiagramObjectComponent
