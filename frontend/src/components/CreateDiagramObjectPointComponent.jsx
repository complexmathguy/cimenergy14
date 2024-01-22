import React, { Component } from 'react'
import DiagramObjectPointService from '../services/DiagramObjectPointService';

class CreateDiagramObjectPointComponent extends Component {
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
            DiagramObjectPointService.getDiagramObjectPointById(this.state.id).then( (res) =>{
                let diagramObjectPoint = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiagramObjectPoint = (e) => {
        e.preventDefault();
        let diagramObjectPoint = {
                diagramObjectPointId: this.state.id,
            };
        console.log('diagramObjectPoint => ' + JSON.stringify(diagramObjectPoint));

        // step 5
        if(this.state.id === '_add'){
            diagramObjectPoint.diagramObjectPointId=''
            DiagramObjectPointService.createDiagramObjectPoint(diagramObjectPoint).then(res =>{
                this.props.history.push('/diagramObjectPoints');
            });
        }else{
            DiagramObjectPointService.updateDiagramObjectPoint(diagramObjectPoint).then( res => {
                this.props.history.push('/diagramObjectPoints');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/diagramObjectPoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramObjectPoint</h3>
        }else{
            return <h3 className="text-center">Update DiagramObjectPoint</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramObjectPoint}>Save</button>
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

export default CreateDiagramObjectPointComponent
