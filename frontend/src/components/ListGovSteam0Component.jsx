import React, { Component } from 'react'
import GovSteam0Service from '../services/GovSteam0Service'

class ListGovSteam0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteam0s: []
        }
        this.addGovSteam0 = this.addGovSteam0.bind(this);
        this.editGovSteam0 = this.editGovSteam0.bind(this);
        this.deleteGovSteam0 = this.deleteGovSteam0.bind(this);
    }

    deleteGovSteam0(id){
        GovSteam0Service.deleteGovSteam0(id).then( res => {
            this.setState({govSteam0s: this.state.govSteam0s.filter(govSteam0 => govSteam0.govSteam0Id !== id)});
        });
    }
    viewGovSteam0(id){
        this.props.history.push(`/view-govSteam0/${id}`);
    }
    editGovSteam0(id){
        this.props.history.push(`/add-govSteam0/${id}`);
    }

    componentDidMount(){
        GovSteam0Service.getGovSteam0s().then((res) => {
            this.setState({ govSteam0s: res.data});
        });
    }

    addGovSteam0(){
        this.props.history.push('/add-govSteam0/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteam0 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteam0}> Add GovSteam0</button>
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
                                    this.state.govSteam0s.map(
                                        govSteam0 => 
                                        <tr key = {govSteam0.govSteam0Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteam0(govSteam0.govSteam0Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteam0(govSteam0.govSteam0Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteam0(govSteam0.govSteam0Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteam0Component
