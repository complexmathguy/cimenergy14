import React, { Component } from 'react'
import TopologicalNodeService from '../services/TopologicalNodeService';

class CreateTopologicalNodeComponent extends Component {
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
            TopologicalNodeService.getTopologicalNodeById(this.state.id).then( (res) =>{
                let topologicalNode = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTopologicalNode = (e) => {
        e.preventDefault();
        let topologicalNode = {
                topologicalNodeId: this.state.id,
            };
        console.log('topologicalNode => ' + JSON.stringify(topologicalNode));

        // step 5
        if(this.state.id === '_add'){
            topologicalNode.topologicalNodeId=''
            TopologicalNodeService.createTopologicalNode(topologicalNode).then(res =>{
                this.props.history.push('/topologicalNodes');
            });
        }else{
            TopologicalNodeService.updateTopologicalNode(topologicalNode).then( res => {
                this.props.history.push('/topologicalNodes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/topologicalNodes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TopologicalNode</h3>
        }else{
            return <h3 className="text-center">Update TopologicalNode</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTopologicalNode}>Save</button>
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

export default CreateTopologicalNodeComponent
