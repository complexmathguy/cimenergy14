import React, { Component } from 'react'
import GovHydroPIDService from '../services/GovHydroPIDService'

class ListGovHydroPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroPIDs: []
        }
        this.addGovHydroPID = this.addGovHydroPID.bind(this);
        this.editGovHydroPID = this.editGovHydroPID.bind(this);
        this.deleteGovHydroPID = this.deleteGovHydroPID.bind(this);
    }

    deleteGovHydroPID(id){
        GovHydroPIDService.deleteGovHydroPID(id).then( res => {
            this.setState({govHydroPIDs: this.state.govHydroPIDs.filter(govHydroPID => govHydroPID.govHydroPIDId !== id)});
        });
    }
    viewGovHydroPID(id){
        this.props.history.push(`/view-govHydroPID/${id}`);
    }
    editGovHydroPID(id){
        this.props.history.push(`/add-govHydroPID/${id}`);
    }

    componentDidMount(){
        GovHydroPIDService.getGovHydroPIDs().then((res) => {
            this.setState({ govHydroPIDs: res.data});
        });
    }

    addGovHydroPID(){
        this.props.history.push('/add-govHydroPID/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroPID List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroPID}> Add GovHydroPID</button>
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
                                    this.state.govHydroPIDs.map(
                                        govHydroPID => 
                                        <tr key = {govHydroPID.govHydroPIDId}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroPID(govHydroPID.govHydroPIDId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroPID(govHydroPID.govHydroPIDId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroPID(govHydroPID.govHydroPIDId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroPIDComponent
