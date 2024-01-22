import React, { Component } from 'react'
import GovGASTService from '../services/GovGASTService'

class ListGovGASTComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGASTs: []
        }
        this.addGovGAST = this.addGovGAST.bind(this);
        this.editGovGAST = this.editGovGAST.bind(this);
        this.deleteGovGAST = this.deleteGovGAST.bind(this);
    }

    deleteGovGAST(id){
        GovGASTService.deleteGovGAST(id).then( res => {
            this.setState({govGASTs: this.state.govGASTs.filter(govGAST => govGAST.govGASTId !== id)});
        });
    }
    viewGovGAST(id){
        this.props.history.push(`/view-govGAST/${id}`);
    }
    editGovGAST(id){
        this.props.history.push(`/add-govGAST/${id}`);
    }

    componentDidMount(){
        GovGASTService.getGovGASTs().then((res) => {
            this.setState({ govGASTs: res.data});
        });
    }

    addGovGAST(){
        this.props.history.push('/add-govGAST/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGAST List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGAST}> Add GovGAST</button>
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
                                    this.state.govGASTs.map(
                                        govGAST => 
                                        <tr key = {govGAST.govGASTId}>
                                             <td>
                                                 <button onClick={ () => this.editGovGAST(govGAST.govGASTId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGAST(govGAST.govGASTId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGAST(govGAST.govGASTId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovGASTComponent
