import React, { Component } from 'react'
import DiagramObjectPointService from '../services/DiagramObjectPointService';

class UpdateDiagramObjectPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiagramObjectPoint = this.updateDiagramObjectPoint.bind(this);

    }

    componentDidMount(){
        DiagramObjectPointService.getDiagramObjectPointById(this.state.id).then( (res) =>{
            let diagramObjectPoint = res.data;
            this.setState({
            });
        });
    }

    updateDiagramObjectPoint = (e) => {
        e.preventDefault();
        let diagramObjectPoint = {
            diagramObjectPointId: this.state.id,
        };
        console.log('diagramObjectPoint => ' + JSON.stringify(diagramObjectPoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramObjectPointService.updateDiagramObjectPoint(diagramObjectPoint).then( res => {
            this.props.history.push('/diagramObjectPoints');
        });
    }


    cancel(){
        this.props.history.push('/diagramObjectPoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiagramObjectPoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagramObjectPoint}>Save</button>
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

export default UpdateDiagramObjectPointComponent
