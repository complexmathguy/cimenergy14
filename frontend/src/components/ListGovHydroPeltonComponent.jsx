import React, { Component } from 'react'
import GovHydroPeltonService from '../services/GovHydroPeltonService'

class ListGovHydroPeltonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroPeltons: []
        }
        this.addGovHydroPelton = this.addGovHydroPelton.bind(this);
        this.editGovHydroPelton = this.editGovHydroPelton.bind(this);
        this.deleteGovHydroPelton = this.deleteGovHydroPelton.bind(this);
    }

    deleteGovHydroPelton(id){
        GovHydroPeltonService.deleteGovHydroPelton(id).then( res => {
            this.setState({govHydroPeltons: this.state.govHydroPeltons.filter(govHydroPelton => govHydroPelton.govHydroPeltonId !== id)});
        });
    }
    viewGovHydroPelton(id){
        this.props.history.push(`/view-govHydroPelton/${id}`);
    }
    editGovHydroPelton(id){
        this.props.history.push(`/add-govHydroPelton/${id}`);
    }

    componentDidMount(){
        GovHydroPeltonService.getGovHydroPeltons().then((res) => {
            this.setState({ govHydroPeltons: res.data});
        });
    }

    addGovHydroPelton(){
        this.props.history.push('/add-govHydroPelton/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroPelton List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroPelton}> Add GovHydroPelton</button>
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
                                    this.state.govHydroPeltons.map(
                                        govHydroPelton => 
                                        <tr key = {govHydroPelton.govHydroPeltonId}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroPelton(govHydroPelton.govHydroPeltonId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroPelton(govHydroPelton.govHydroPeltonId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroPelton(govHydroPelton.govHydroPeltonId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroPeltonComponent
