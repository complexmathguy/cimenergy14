import React, { Component } from 'react'
import GovSteamCCService from '../services/GovSteamCCService'

class ListGovSteamCCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamCCs: []
        }
        this.addGovSteamCC = this.addGovSteamCC.bind(this);
        this.editGovSteamCC = this.editGovSteamCC.bind(this);
        this.deleteGovSteamCC = this.deleteGovSteamCC.bind(this);
    }

    deleteGovSteamCC(id){
        GovSteamCCService.deleteGovSteamCC(id).then( res => {
            this.setState({govSteamCCs: this.state.govSteamCCs.filter(govSteamCC => govSteamCC.govSteamCCId !== id)});
        });
    }
    viewGovSteamCC(id){
        this.props.history.push(`/view-govSteamCC/${id}`);
    }
    editGovSteamCC(id){
        this.props.history.push(`/add-govSteamCC/${id}`);
    }

    componentDidMount(){
        GovSteamCCService.getGovSteamCCs().then((res) => {
            this.setState({ govSteamCCs: res.data});
        });
    }

    addGovSteamCC(){
        this.props.history.push('/add-govSteamCC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamCC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamCC}> Add GovSteamCC</button>
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
                                    this.state.govSteamCCs.map(
                                        govSteamCC => 
                                        <tr key = {govSteamCC.govSteamCCId}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamCC(govSteamCC.govSteamCCId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamCC(govSteamCC.govSteamCCId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamCC(govSteamCC.govSteamCCId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamCCComponent
