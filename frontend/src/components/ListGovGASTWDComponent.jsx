import React, { Component } from 'react'
import GovGASTWDService from '../services/GovGASTWDService'

class ListGovGASTWDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGASTWDs: []
        }
        this.addGovGASTWD = this.addGovGASTWD.bind(this);
        this.editGovGASTWD = this.editGovGASTWD.bind(this);
        this.deleteGovGASTWD = this.deleteGovGASTWD.bind(this);
    }

    deleteGovGASTWD(id){
        GovGASTWDService.deleteGovGASTWD(id).then( res => {
            this.setState({govGASTWDs: this.state.govGASTWDs.filter(govGASTWD => govGASTWD.govGASTWDId !== id)});
        });
    }
    viewGovGASTWD(id){
        this.props.history.push(`/view-govGASTWD/${id}`);
    }
    editGovGASTWD(id){
        this.props.history.push(`/add-govGASTWD/${id}`);
    }

    componentDidMount(){
        GovGASTWDService.getGovGASTWDs().then((res) => {
            this.setState({ govGASTWDs: res.data});
        });
    }

    addGovGASTWD(){
        this.props.history.push('/add-govGASTWD/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGASTWD List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGASTWD}> Add GovGASTWD</button>
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
                                    this.state.govGASTWDs.map(
                                        govGASTWD => 
                                        <tr key = {govGASTWD.govGASTWDId}>
                                             <td>
                                                 <button onClick={ () => this.editGovGASTWD(govGASTWD.govGASTWDId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGASTWD(govGASTWD.govGASTWDId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGASTWD(govGASTWD.govGASTWDId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovGASTWDComponent
