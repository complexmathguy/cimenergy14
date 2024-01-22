import React, { Component } from 'react'
import GovSteam2Service from '../services/GovSteam2Service'

class ListGovSteam2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteam2s: []
        }
        this.addGovSteam2 = this.addGovSteam2.bind(this);
        this.editGovSteam2 = this.editGovSteam2.bind(this);
        this.deleteGovSteam2 = this.deleteGovSteam2.bind(this);
    }

    deleteGovSteam2(id){
        GovSteam2Service.deleteGovSteam2(id).then( res => {
            this.setState({govSteam2s: this.state.govSteam2s.filter(govSteam2 => govSteam2.govSteam2Id !== id)});
        });
    }
    viewGovSteam2(id){
        this.props.history.push(`/view-govSteam2/${id}`);
    }
    editGovSteam2(id){
        this.props.history.push(`/add-govSteam2/${id}`);
    }

    componentDidMount(){
        GovSteam2Service.getGovSteam2s().then((res) => {
            this.setState({ govSteam2s: res.data});
        });
    }

    addGovSteam2(){
        this.props.history.push('/add-govSteam2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteam2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteam2}> Add GovSteam2</button>
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
                                    this.state.govSteam2s.map(
                                        govSteam2 => 
                                        <tr key = {govSteam2.govSteam2Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovSteam2(govSteam2.govSteam2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteam2(govSteam2.govSteam2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteam2(govSteam2.govSteam2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovSteam2Component
