import React, { Component } from 'react'
import GovCT2Service from '../services/GovCT2Service'

class ListGovCT2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govCT2s: []
        }
        this.addGovCT2 = this.addGovCT2.bind(this);
        this.editGovCT2 = this.editGovCT2.bind(this);
        this.deleteGovCT2 = this.deleteGovCT2.bind(this);
    }

    deleteGovCT2(id){
        GovCT2Service.deleteGovCT2(id).then( res => {
            this.setState({govCT2s: this.state.govCT2s.filter(govCT2 => govCT2.govCT2Id !== id)});
        });
    }
    viewGovCT2(id){
        this.props.history.push(`/view-govCT2/${id}`);
    }
    editGovCT2(id){
        this.props.history.push(`/add-govCT2/${id}`);
    }

    componentDidMount(){
        GovCT2Service.getGovCT2s().then((res) => {
            this.setState({ govCT2s: res.data});
        });
    }

    addGovCT2(){
        this.props.history.push('/add-govCT2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovCT2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovCT2}> Add GovCT2</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Rselect </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govCT2s.map(
                                        govCT2 => 
                                        <tr key = {govCT2.govCT2Id}>
                                             <td> { govCT2.rselect } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovCT2(govCT2.govCT2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovCT2(govCT2.govCT2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovCT2(govCT2.govCT2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovCT2Component
