import React, { Component } from 'react'
import GovSteamSGOService from '../services/GovSteamSGOService'

class ListGovSteamSGOComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamSGOs: []
        }
        this.addGovSteamSGO = this.addGovSteamSGO.bind(this);
        this.editGovSteamSGO = this.editGovSteamSGO.bind(this);
        this.deleteGovSteamSGO = this.deleteGovSteamSGO.bind(this);
    }

    deleteGovSteamSGO(id){
        GovSteamSGOService.deleteGovSteamSGO(id).then( res => {
            this.setState({govSteamSGOs: this.state.govSteamSGOs.filter(govSteamSGO => govSteamSGO.govSteamSGOId !== id)});
        });
    }
    viewGovSteamSGO(id){
        this.props.history.push(`/view-govSteamSGO/${id}`);
    }
    editGovSteamSGO(id){
        this.props.history.push(`/add-govSteamSGO/${id}`);
    }

    componentDidMount(){
        GovSteamSGOService.getGovSteamSGOs().then((res) => {
            this.setState({ govSteamSGOs: res.data});
        });
    }

    addGovSteamSGO(){
        this.props.history.push('/add-govSteamSGO/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamSGO List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamSGO}> Add GovSteamSGO</button>
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
                                    this.state.govSteamSGOs.map(
                                        govSteamSGO => 
                                        <tr key = {govSteamSGO.govSteamSGOId}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamSGO(govSteamSGO.govSteamSGOId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamSGO(govSteamSGO.govSteamSGOId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamSGO(govSteamSGO.govSteamSGOId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamSGOComponent
