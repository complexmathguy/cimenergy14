import React, { Component } from 'react'
import GovHydroRService from '../services/GovHydroRService'

class ListGovHydroRComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroRs: []
        }
        this.addGovHydroR = this.addGovHydroR.bind(this);
        this.editGovHydroR = this.editGovHydroR.bind(this);
        this.deleteGovHydroR = this.deleteGovHydroR.bind(this);
    }

    deleteGovHydroR(id){
        GovHydroRService.deleteGovHydroR(id).then( res => {
            this.setState({govHydroRs: this.state.govHydroRs.filter(govHydroR => govHydroR.govHydroRId !== id)});
        });
    }
    viewGovHydroR(id){
        this.props.history.push(`/view-govHydroR/${id}`);
    }
    editGovHydroR(id){
        this.props.history.push(`/add-govHydroR/${id}`);
    }

    componentDidMount(){
        GovHydroRService.getGovHydroRs().then((res) => {
            this.setState({ govHydroRs: res.data});
        });
    }

    addGovHydroR(){
        this.props.history.push('/add-govHydroR/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroR List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroR}> Add GovHydroR</button>
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
                                    this.state.govHydroRs.map(
                                        govHydroR => 
                                        <tr key = {govHydroR.govHydroRId}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroR(govHydroR.govHydroRId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroR(govHydroR.govHydroRId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroR(govHydroR.govHydroRId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroRComponent
