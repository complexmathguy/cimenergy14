import React, { Component } from 'react'
import GovGAST2Service from '../services/GovGAST2Service'

class ListGovGAST2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGAST2s: []
        }
        this.addGovGAST2 = this.addGovGAST2.bind(this);
        this.editGovGAST2 = this.editGovGAST2.bind(this);
        this.deleteGovGAST2 = this.deleteGovGAST2.bind(this);
    }

    deleteGovGAST2(id){
        GovGAST2Service.deleteGovGAST2(id).then( res => {
            this.setState({govGAST2s: this.state.govGAST2s.filter(govGAST2 => govGAST2.govGAST2Id !== id)});
        });
    }
    viewGovGAST2(id){
        this.props.history.push(`/view-govGAST2/${id}`);
    }
    editGovGAST2(id){
        this.props.history.push(`/add-govGAST2/${id}`);
    }

    componentDidMount(){
        GovGAST2Service.getGovGAST2s().then((res) => {
            this.setState({ govGAST2s: res.data});
        });
    }

    addGovGAST2(){
        this.props.history.push('/add-govGAST2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGAST2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGAST2}> Add GovGAST2</button>
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
                                    this.state.govGAST2s.map(
                                        govGAST2 => 
                                        <tr key = {govGAST2.govGAST2Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovGAST2(govGAST2.govGAST2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGAST2(govGAST2.govGAST2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGAST2(govGAST2.govGAST2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovGAST2Component
