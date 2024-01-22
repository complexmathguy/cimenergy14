import React, { Component } from 'react'
import TopologyVersionService from '../services/TopologyVersionService';

class CreateTopologyVersionComponent extends Component {
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
            TopologyVersionService.getTopologyVersionById(this.state.id).then( (res) =>{
                let topologyVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTopologyVersion = (e) => {
        e.preventDefault();
        let topologyVersion = {
                topologyVersionId: this.state.id,
            };
        console.log('topologyVersion => ' + JSON.stringify(topologyVersion));

        // step 5
        if(this.state.id === '_add'){
            topologyVersion.topologyVersionId=''
            TopologyVersionService.createTopologyVersion(topologyVersion).then(res =>{
                this.props.history.push('/topologyVersions');
            });
        }else{
            TopologyVersionService.updateTopologyVersion(topologyVersion).then( res => {
                this.props.history.push('/topologyVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/topologyVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TopologyVersion</h3>
        }else{
            return <h3 className="text-center">Update TopologyVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTopologyVersion}>Save</button>
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

export default CreateTopologyVersionComponent
