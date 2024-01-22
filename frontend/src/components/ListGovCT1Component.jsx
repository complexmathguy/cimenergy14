import React, { Component } from 'react'
import GovCT1Service from '../services/GovCT1Service'

class ListGovCT1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govCT1s: []
        }
        this.addGovCT1 = this.addGovCT1.bind(this);
        this.editGovCT1 = this.editGovCT1.bind(this);
        this.deleteGovCT1 = this.deleteGovCT1.bind(this);
    }

    deleteGovCT1(id){
        GovCT1Service.deleteGovCT1(id).then( res => {
            this.setState({govCT1s: this.state.govCT1s.filter(govCT1 => govCT1.govCT1Id !== id)});
        });
    }
    viewGovCT1(id){
        this.props.history.push(`/view-govCT1/${id}`);
    }
    editGovCT1(id){
        this.props.history.push(`/add-govCT1/${id}`);
    }

    componentDidMount(){
        GovCT1Service.getGovCT1s().then((res) => {
            this.setState({ govCT1s: res.data});
        });
    }

    addGovCT1(){
        this.props.history.push('/add-govCT1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovCT1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovCT1}> Add GovCT1</button>
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
                                    this.state.govCT1s.map(
                                        govCT1 => 
                                        <tr key = {govCT1.govCT1Id}>
                                             <td> { govCT1.rselect } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovCT1(govCT1.govCT1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovCT1(govCT1.govCT1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovCT1(govCT1.govCT1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovCT1Component
