import React, { Component } from 'react'
import GovHydroWPIDService from '../services/GovHydroWPIDService'

class ListGovHydroWPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroWPIDs: []
        }
        this.addGovHydroWPID = this.addGovHydroWPID.bind(this);
        this.editGovHydroWPID = this.editGovHydroWPID.bind(this);
        this.deleteGovHydroWPID = this.deleteGovHydroWPID.bind(this);
    }

    deleteGovHydroWPID(id){
        GovHydroWPIDService.deleteGovHydroWPID(id).then( res => {
            this.setState({govHydroWPIDs: this.state.govHydroWPIDs.filter(govHydroWPID => govHydroWPID.govHydroWPIDId !== id)});
        });
    }
    viewGovHydroWPID(id){
        this.props.history.push(`/view-govHydroWPID/${id}`);
    }
    editGovHydroWPID(id){
        this.props.history.push(`/add-govHydroWPID/${id}`);
    }

    componentDidMount(){
        GovHydroWPIDService.getGovHydroWPIDs().then((res) => {
            this.setState({ govHydroWPIDs: res.data});
        });
    }

    addGovHydroWPID(){
        this.props.history.push('/add-govHydroWPID/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroWPID List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroWPID}> Add GovHydroWPID</button>
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
                                    this.state.govHydroWPIDs.map(
                                        govHydroWPID => 
                                        <tr key = {govHydroWPID.govHydroWPIDId}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroWPID(govHydroWPID.govHydroWPIDId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroWPID(govHydroWPID.govHydroWPIDId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroWPID(govHydroWPID.govHydroWPIDId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroWPIDComponent
