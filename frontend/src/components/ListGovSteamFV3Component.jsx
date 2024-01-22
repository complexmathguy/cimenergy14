import React, { Component } from 'react'
import GovSteamFV3Service from '../services/GovSteamFV3Service'

class ListGovSteamFV3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamFV3s: []
        }
        this.addGovSteamFV3 = this.addGovSteamFV3.bind(this);
        this.editGovSteamFV3 = this.editGovSteamFV3.bind(this);
        this.deleteGovSteamFV3 = this.deleteGovSteamFV3.bind(this);
    }

    deleteGovSteamFV3(id){
        GovSteamFV3Service.deleteGovSteamFV3(id).then( res => {
            this.setState({govSteamFV3s: this.state.govSteamFV3s.filter(govSteamFV3 => govSteamFV3.govSteamFV3Id !== id)});
        });
    }
    viewGovSteamFV3(id){
        this.props.history.push(`/view-govSteamFV3/${id}`);
    }
    editGovSteamFV3(id){
        this.props.history.push(`/add-govSteamFV3/${id}`);
    }

    componentDidMount(){
        GovSteamFV3Service.getGovSteamFV3s().then((res) => {
            this.setState({ govSteamFV3s: res.data});
        });
    }

    addGovSteamFV3(){
        this.props.history.push('/add-govSteamFV3/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamFV3 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamFV3}> Add GovSteamFV3</button>
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
                                    this.state.govSteamFV3s.map(
                                        govSteamFV3 => 
                                        <tr key = {govSteamFV3.govSteamFV3Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamFV3(govSteamFV3.govSteamFV3Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamFV3(govSteamFV3.govSteamFV3Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamFV3(govSteamFV3.govSteamFV3Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamFV3Component
