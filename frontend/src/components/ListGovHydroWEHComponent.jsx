import React, { Component } from 'react'
import GovHydroWEHService from '../services/GovHydroWEHService'

class ListGovHydroWEHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroWEHs: []
        }
        this.addGovHydroWEH = this.addGovHydroWEH.bind(this);
        this.editGovHydroWEH = this.editGovHydroWEH.bind(this);
        this.deleteGovHydroWEH = this.deleteGovHydroWEH.bind(this);
    }

    deleteGovHydroWEH(id){
        GovHydroWEHService.deleteGovHydroWEH(id).then( res => {
            this.setState({govHydroWEHs: this.state.govHydroWEHs.filter(govHydroWEH => govHydroWEH.govHydroWEHId !== id)});
        });
    }
    viewGovHydroWEH(id){
        this.props.history.push(`/view-govHydroWEH/${id}`);
    }
    editGovHydroWEH(id){
        this.props.history.push(`/add-govHydroWEH/${id}`);
    }

    componentDidMount(){
        GovHydroWEHService.getGovHydroWEHs().then((res) => {
            this.setState({ govHydroWEHs: res.data});
        });
    }

    addGovHydroWEH(){
        this.props.history.push('/add-govHydroWEH/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroWEH List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroWEH}> Add GovHydroWEH</button>
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
                                    this.state.govHydroWEHs.map(
                                        govHydroWEH => 
                                        <tr key = {govHydroWEH.govHydroWEHId}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroWEH(govHydroWEH.govHydroWEHId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroWEH(govHydroWEH.govHydroWEHId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroWEH(govHydroWEH.govHydroWEHId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroWEHComponent
