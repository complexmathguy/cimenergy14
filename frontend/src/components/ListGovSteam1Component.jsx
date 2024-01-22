import React, { Component } from 'react'
import GovSteam1Service from '../services/GovSteam1Service'

class ListGovSteam1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteam1s: []
        }
        this.addGovSteam1 = this.addGovSteam1.bind(this);
        this.editGovSteam1 = this.editGovSteam1.bind(this);
        this.deleteGovSteam1 = this.deleteGovSteam1.bind(this);
    }

    deleteGovSteam1(id){
        GovSteam1Service.deleteGovSteam1(id).then( res => {
            this.setState({govSteam1s: this.state.govSteam1s.filter(govSteam1 => govSteam1.govSteam1Id !== id)});
        });
    }
    viewGovSteam1(id){
        this.props.history.push(`/view-govSteam1/${id}`);
    }
    editGovSteam1(id){
        this.props.history.push(`/add-govSteam1/${id}`);
    }

    componentDidMount(){
        GovSteam1Service.getGovSteam1s().then((res) => {
            this.setState({ govSteam1s: res.data});
        });
    }

    addGovSteam1(){
        this.props.history.push('/add-govSteam1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteam1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteam1}> Add GovSteam1</button>
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
                                    this.state.govSteam1s.map(
                                        govSteam1 => 
                                        <tr key = {govSteam1.govSteam1Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteam1(govSteam1.govSteam1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteam1(govSteam1.govSteam1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteam1(govSteam1.govSteam1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteam1Component
