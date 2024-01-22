import React, { Component } from 'react'
import GovHydroDDService from '../services/GovHydroDDService'

class ListGovHydroDDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroDDs: []
        }
        this.addGovHydroDD = this.addGovHydroDD.bind(this);
        this.editGovHydroDD = this.editGovHydroDD.bind(this);
        this.deleteGovHydroDD = this.deleteGovHydroDD.bind(this);
    }

    deleteGovHydroDD(id){
        GovHydroDDService.deleteGovHydroDD(id).then( res => {
            this.setState({govHydroDDs: this.state.govHydroDDs.filter(govHydroDD => govHydroDD.govHydroDDId !== id)});
        });
    }
    viewGovHydroDD(id){
        this.props.history.push(`/view-govHydroDD/${id}`);
    }
    editGovHydroDD(id){
        this.props.history.push(`/add-govHydroDD/${id}`);
    }

    componentDidMount(){
        GovHydroDDService.getGovHydroDDs().then((res) => {
            this.setState({ govHydroDDs: res.data});
        });
    }

    addGovHydroDD(){
        this.props.history.push('/add-govHydroDD/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroDD List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroDD}> Add GovHydroDD</button>
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
                                    this.state.govHydroDDs.map(
                                        govHydroDD => 
                                        <tr key = {govHydroDD.govHydroDDId}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroDD(govHydroDD.govHydroDDId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroDD(govHydroDD.govHydroDDId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroDD(govHydroDD.govHydroDDId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroDDComponent
