import React, { Component } from 'react'
import GovHydro4Service from '../services/GovHydro4Service'

class ListGovHydro4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydro4s: []
        }
        this.addGovHydro4 = this.addGovHydro4.bind(this);
        this.editGovHydro4 = this.editGovHydro4.bind(this);
        this.deleteGovHydro4 = this.deleteGovHydro4.bind(this);
    }

    deleteGovHydro4(id){
        GovHydro4Service.deleteGovHydro4(id).then( res => {
            this.setState({govHydro4s: this.state.govHydro4s.filter(govHydro4 => govHydro4.govHydro4Id !== id)});
        });
    }
    viewGovHydro4(id){
        this.props.history.push(`/view-govHydro4/${id}`);
    }
    editGovHydro4(id){
        this.props.history.push(`/add-govHydro4/${id}`);
    }

    componentDidMount(){
        GovHydro4Service.getGovHydro4s().then((res) => {
            this.setState({ govHydro4s: res.data});
        });
    }

    addGovHydro4(){
        this.props.history.push('/add-govHydro4/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydro4 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydro4}> Add GovHydro4</button>
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
                                    this.state.govHydro4s.map(
                                        govHydro4 => 
                                        <tr key = {govHydro4.govHydro4Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydro4(govHydro4.govHydro4Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydro4(govHydro4.govHydro4Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydro4(govHydro4.govHydro4Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydro4Component
