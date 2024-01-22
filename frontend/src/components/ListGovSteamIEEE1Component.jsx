import React, { Component } from 'react'
import GovSteamIEEE1Service from '../services/GovSteamIEEE1Service'

class ListGovSteamIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteamIEEE1s: []
        }
        this.addGovSteamIEEE1 = this.addGovSteamIEEE1.bind(this);
        this.editGovSteamIEEE1 = this.editGovSteamIEEE1.bind(this);
        this.deleteGovSteamIEEE1 = this.deleteGovSteamIEEE1.bind(this);
    }

    deleteGovSteamIEEE1(id){
        GovSteamIEEE1Service.deleteGovSteamIEEE1(id).then( res => {
            this.setState({govSteamIEEE1s: this.state.govSteamIEEE1s.filter(govSteamIEEE1 => govSteamIEEE1.govSteamIEEE1Id !== id)});
        });
    }
    viewGovSteamIEEE1(id){
        this.props.history.push(`/view-govSteamIEEE1/${id}`);
    }
    editGovSteamIEEE1(id){
        this.props.history.push(`/add-govSteamIEEE1/${id}`);
    }

    componentDidMount(){
        GovSteamIEEE1Service.getGovSteamIEEE1s().then((res) => {
            this.setState({ govSteamIEEE1s: res.data});
        });
    }

    addGovSteamIEEE1(){
        this.props.history.push('/add-govSteamIEEE1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteamIEEE1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteamIEEE1}> Add GovSteamIEEE1</button>
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
                                    this.state.govSteamIEEE1s.map(
                                        govSteamIEEE1 => 
                                        <tr key = {govSteamIEEE1.govSteamIEEE1Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteamIEEE1(govSteamIEEE1.govSteamIEEE1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteamIEEE1(govSteamIEEE1.govSteamIEEE1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteamIEEE1(govSteamIEEE1.govSteamIEEE1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteamIEEE1Component
