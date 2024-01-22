import React, { Component } from 'react'
import GovGAST1Service from '../services/GovGAST1Service'

class ListGovGAST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGAST1s: []
        }
        this.addGovGAST1 = this.addGovGAST1.bind(this);
        this.editGovGAST1 = this.editGovGAST1.bind(this);
        this.deleteGovGAST1 = this.deleteGovGAST1.bind(this);
    }

    deleteGovGAST1(id){
        GovGAST1Service.deleteGovGAST1(id).then( res => {
            this.setState({govGAST1s: this.state.govGAST1s.filter(govGAST1 => govGAST1.govGAST1Id !== id)});
        });
    }
    viewGovGAST1(id){
        this.props.history.push(`/view-govGAST1/${id}`);
    }
    editGovGAST1(id){
        this.props.history.push(`/add-govGAST1/${id}`);
    }

    componentDidMount(){
        GovGAST1Service.getGovGAST1s().then((res) => {
            this.setState({ govGAST1s: res.data});
        });
    }

    addGovGAST1(){
        this.props.history.push('/add-govGAST1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGAST1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGAST1}> Add GovGAST1</button>
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
                                    this.state.govGAST1s.map(
                                        govGAST1 => 
                                        <tr key = {govGAST1.govGAST1Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovGAST1(govGAST1.govGAST1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGAST1(govGAST1.govGAST1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGAST1(govGAST1.govGAST1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovGAST1Component
