import React, { Component } from 'react'
import TopologicalNodeService from '../services/TopologicalNodeService';

class UpdateTopologicalNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTopologicalNode = this.updateTopologicalNode.bind(this);

    }

    componentDidMount(){
        TopologicalNodeService.getTopologicalNodeById(this.state.id).then( (res) =>{
            let topologicalNode = res.data;
            this.setState({
            });
        });
    }

    updateTopologicalNode = (e) => {
        e.preventDefault();
        let topologicalNode = {
            topologicalNodeId: this.state.id,
        };
        console.log('topologicalNode => ' + JSON.stringify(topologicalNode));
        console.log('id => ' + JSON.stringify(this.state.id));
        TopologicalNodeService.updateTopologicalNode(topologicalNode).then( res => {
            this.props.history.push('/topologicalNodes');
        });
    }


    cancel(){
        this.props.history.push('/topologicalNodes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TopologicalNode</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTopologicalNode}>Save</button>
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

export default UpdateTopologicalNodeComponent
