import React, { Component } from 'react'
import GovHydroFrancisService from '../services/GovHydroFrancisService'

class ListGovHydroFrancisComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroFranciss: []
        }
        this.addGovHydroFrancis = this.addGovHydroFrancis.bind(this);
        this.editGovHydroFrancis = this.editGovHydroFrancis.bind(this);
        this.deleteGovHydroFrancis = this.deleteGovHydroFrancis.bind(this);
    }

    deleteGovHydroFrancis(id){
        GovHydroFrancisService.deleteGovHydroFrancis(id).then( res => {
            this.setState({govHydroFranciss: this.state.govHydroFranciss.filter(govHydroFrancis => govHydroFrancis.govHydroFrancisId !== id)});
        });
    }
    viewGovHydroFrancis(id){
        this.props.history.push(`/view-govHydroFrancis/${id}`);
    }
    editGovHydroFrancis(id){
        this.props.history.push(`/add-govHydroFrancis/${id}`);
    }

    componentDidMount(){
        GovHydroFrancisService.getGovHydroFranciss().then((res) => {
            this.setState({ govHydroFranciss: res.data});
        });
    }

    addGovHydroFrancis(){
        this.props.history.push('/add-govHydroFrancis/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroFrancis List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroFrancis}> Add GovHydroFrancis</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> GovernorControl </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroFranciss.map(
                                        govHydroFrancis => 
                                        <tr key = {govHydroFrancis.govHydroFrancisId}>
                                             <td> { govHydroFrancis.governorControl } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroFrancis(govHydroFrancis.govHydroFrancisId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroFrancis(govHydroFrancis.govHydroFrancisId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroFrancis(govHydroFrancis.govHydroFrancisId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroFrancisComponent
