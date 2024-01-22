import React, { Component } from 'react'
import GovHydro2Service from '../services/GovHydro2Service'

class ListGovHydro2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydro2s: []
        }
        this.addGovHydro2 = this.addGovHydro2.bind(this);
        this.editGovHydro2 = this.editGovHydro2.bind(this);
        this.deleteGovHydro2 = this.deleteGovHydro2.bind(this);
    }

    deleteGovHydro2(id){
        GovHydro2Service.deleteGovHydro2(id).then( res => {
            this.setState({govHydro2s: this.state.govHydro2s.filter(govHydro2 => govHydro2.govHydro2Id !== id)});
        });
    }
    viewGovHydro2(id){
        this.props.history.push(`/view-govHydro2/${id}`);
    }
    editGovHydro2(id){
        this.props.history.push(`/add-govHydro2/${id}`);
    }

    componentDidMount(){
        GovHydro2Service.getGovHydro2s().then((res) => {
            this.setState({ govHydro2s: res.data});
        });
    }

    addGovHydro2(){
        this.props.history.push('/add-govHydro2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydro2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydro2}> Add GovHydro2</button>
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
                                    this.state.govHydro2s.map(
                                        govHydro2 => 
                                        <tr key = {govHydro2.govHydro2Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydro2(govHydro2.govHydro2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydro2(govHydro2.govHydro2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydro2(govHydro2.govHydro2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydro2Component
