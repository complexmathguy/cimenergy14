import React, { Component } from 'react'
import TopologyBoundaryVersionService from '../services/TopologyBoundaryVersionService';

class UpdateTopologyBoundaryVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTopologyBoundaryVersion = this.updateTopologyBoundaryVersion.bind(this);

    }

    componentDidMount(){
        TopologyBoundaryVersionService.getTopologyBoundaryVersionById(this.state.id).then( (res) =>{
            let topologyBoundaryVersion = res.data;
            this.setState({
            });
        });
    }

    updateTopologyBoundaryVersion = (e) => {
        e.preventDefault();
        let topologyBoundaryVersion = {
            topologyBoundaryVersionId: this.state.id,
        };
        console.log('topologyBoundaryVersion => ' + JSON.stringify(topologyBoundaryVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        TopologyBoundaryVersionService.updateTopologyBoundaryVersion(topologyBoundaryVersion).then( res => {
            this.props.history.push('/topologyBoundaryVersions');
        });
    }


    cancel(){
        this.props.history.push('/topologyBoundaryVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TopologyBoundaryVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTopologyBoundaryVersion}>Save</button>
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

export default UpdateTopologyBoundaryVersionComponent
