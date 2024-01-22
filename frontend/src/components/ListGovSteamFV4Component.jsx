import React, { Component } from 'react'
import GovSteamFV4Service from '../services/GovSteamFV4Service'

class ListGovSteamFV4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamFV4s: []
        }
        this.addGovSteamFV4 = this.addGovSteamFV4.bind(this);
        this.editGovSteamFV4 = this.editGovSteamFV4.bind(this);
        this.deleteGovSteamFV4 = this.deleteGovSteamFV4.bind(this);
    }

    deleteGovSteamFV4(id){
        GovSteamFV4Service.deleteGovSteamFV4(id).then( res => {
            this.setState({govSteamFV4s: this.state.govSteamFV4s.filter(govSteamFV4 => govSteamFV4.govSteamFV4Id !== id)});
        });
    }
    viewGovSteamFV4(id){
        this.props.history.push(`/view-govSteamFV4/${id}`);
    }
    editGovSteamFV4(id){
        this.props.history.push(`/add-govSteamFV4/${id}`);
    }

    componentDidMount(){
        GovSteamFV4Service.getGovSteamFV4s().then((res) => {
            this.setState({ govSteamFV4s: res.data});
        });
    }

    addGovSteamFV4(){
        this.props.history.push('/add-govSteamFV4/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamFV4 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamFV4}> Add GovSteamFV4</button>
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
                                    this.state.govSteamFV4s.map(
                                        govSteamFV4 => 
                                        <tr key = {govSteamFV4.govSteamFV4Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamFV4(govSteamFV4.govSteamFV4Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamFV4(govSteamFV4.govSteamFV4Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamFV4(govSteamFV4.govSteamFV4Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamFV4Component
