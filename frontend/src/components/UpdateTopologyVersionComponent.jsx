import React, { Component } from 'react'
import TopologyVersionService from '../services/TopologyVersionService';

class UpdateTopologyVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTopologyVersion = this.updateTopologyVersion.bind(this);

    }

    componentDidMount(){
        TopologyVersionService.getTopologyVersionById(this.state.id).then( (res) =>{
            let topologyVersion = res.data;
            this.setState({
            });
        });
    }

    updateTopologyVersion = (e) => {
        e.preventDefault();
        let topologyVersion = {
            topologyVersionId: this.state.id,
        };
        console.log('topologyVersion => ' + JSON.stringify(topologyVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        TopologyVersionService.updateTopologyVersion(topologyVersion).then( res => {
            this.props.history.push('/topologyVersions');
        });
    }


    cancel(){
        this.props.history.push('/topologyVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TopologyVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTopologyVersion}>Save</button>
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

export default UpdateTopologyVersionComponent
