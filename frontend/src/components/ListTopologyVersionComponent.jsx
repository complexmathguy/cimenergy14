import React, { Component } from 'react'
import TopologyVersionService from '../services/TopologyVersionService'

class ListTopologyVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                topologyVersions: []
        }
        this.addTopologyVersion = this.addTopologyVersion.bind(this);
        this.editTopologyVersion = this.editTopologyVersion.bind(this);
        this.deleteTopologyVersion = this.deleteTopologyVersion.bind(this);
    }

    deleteTopologyVersion(id){
        TopologyVersionService.deleteTopologyVersion(id).then( res => {
            this.setState({topologyVersions: this.state.topologyVersions.filter(topologyVersion => topologyVersion.topologyVersionId !== id)});
        });
    }
    viewTopologyVersion(id){
        this.props.history.push(`/view-topologyVersion/${id}`);
    }
    editTopologyVersion(id){
        this.props.history.push(`/add-topologyVersion/${id}`);
    }

    componentDidMount(){
        TopologyVersionService.getTopologyVersions().then((res) => {
            this.setState({ topologyVersions: res.data});
        });
    }

    addTopologyVersion(){
        this.props.history.push('/add-topologyVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TopologyVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTopologyVersion}> Add TopologyVersion</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.topologyVersions.map(
                                        topologyVersion => 
                                        <tr key = {topologyVersion.topologyVersionId}>
                                             <td>
                                                 <button onClick={ () => this.editTopologyVersion(topologyVersion.topologyVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTopologyVersion(topologyVersion.topologyVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTopologyVersion(topologyVersion.topologyVersionId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListTopologyVersionComponent
