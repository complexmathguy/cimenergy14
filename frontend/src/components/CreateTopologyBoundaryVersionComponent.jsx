import React, { Component } from 'react'
import TopologyBoundaryVersionService from '../services/TopologyBoundaryVersionService';

class CreateTopologyBoundaryVersionComponent extends Component {
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
            TopologyBoundaryVersionService.getTopologyBoundaryVersionById(this.state.id).then( (res) =>{
                let topologyBoundaryVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTopologyBoundaryVersion = (e) => {
        e.preventDefault();
        let topologyBoundaryVersion = {
                topologyBoundaryVersionId: this.state.id,
            };
        console.log('topologyBoundaryVersion => ' + JSON.stringify(topologyBoundaryVersion));

        // step 5
        if(this.state.id === '_add'){
            topologyBoundaryVersion.topologyBoundaryVersionId=''
            TopologyBoundaryVersionService.createTopologyBoundaryVersion(topologyBoundaryVersion).then(res =>{
                this.props.history.push('/topologyBoundaryVersions');
            });
        }else{
            TopologyBoundaryVersionService.updateTopologyBoundaryVersion(topologyBoundaryVersion).then( res => {
                this.props.history.push('/topologyBoundaryVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/topologyBoundaryVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TopologyBoundaryVersion</h3>
        }else{
            return <h3 className="text-center">Update TopologyBoundaryVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTopologyBoundaryVersion}>Save</button>
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

export default CreateTopologyBoundaryVersionComponent
