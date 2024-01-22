import React, { Component } from 'react'
import GovSteamEUService from '../services/GovSteamEUService'

class ListGovSteamEUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamEUs: []
        }
        this.addGovSteamEU = this.addGovSteamEU.bind(this);
        this.editGovSteamEU = this.editGovSteamEU.bind(this);
        this.deleteGovSteamEU = this.deleteGovSteamEU.bind(this);
    }

    deleteGovSteamEU(id){
        GovSteamEUService.deleteGovSteamEU(id).then( res => {
            this.setState({govSteamEUs: this.state.govSteamEUs.filter(govSteamEU => govSteamEU.govSteamEUId !== id)});
        });
    }
    viewGovSteamEU(id){
        this.props.history.push(`/view-govSteamEU/${id}`);
    }
    editGovSteamEU(id){
        this.props.history.push(`/add-govSteamEU/${id}`);
    }

    componentDidMount(){
        GovSteamEUService.getGovSteamEUs().then((res) => {
            this.setState({ govSteamEUs: res.data});
        });
    }

    addGovSteamEU(){
        this.props.history.push('/add-govSteamEU/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamEU List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamEU}> Add GovSteamEU</button>
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
                                    this.state.govSteamEUs.map(
                                        govSteamEU => 
                                        <tr key = {govSteamEU.govSteamEUId}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamEU(govSteamEU.govSteamEUId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamEU(govSteamEU.govSteamEUId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamEU(govSteamEU.govSteamEUId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamEUComponent
