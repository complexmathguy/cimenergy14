import React, { Component } from 'react'
import GovHydro3Service from '../services/GovHydro3Service'

class ListGovHydro3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydro3s: []
        }
        this.addGovHydro3 = this.addGovHydro3.bind(this);
        this.editGovHydro3 = this.editGovHydro3.bind(this);
        this.deleteGovHydro3 = this.deleteGovHydro3.bind(this);
    }

    deleteGovHydro3(id){
        GovHydro3Service.deleteGovHydro3(id).then( res => {
            this.setState({govHydro3s: this.state.govHydro3s.filter(govHydro3 => govHydro3.govHydro3Id !== id)});
        });
    }
    viewGovHydro3(id){
        this.props.history.push(`/view-govHydro3/${id}`);
    }
    editGovHydro3(id){
        this.props.history.push(`/add-govHydro3/${id}`);
    }

    componentDidMount(){
        GovHydro3Service.getGovHydro3s().then((res) => {
            this.setState({ govHydro3s: res.data});
        });
    }

    addGovHydro3(){
        this.props.history.push('/add-govHydro3/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydro3 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydro3}> Add GovHydro3</button>
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
                                    this.state.govHydro3s.map(
                                        govHydro3 => 
                                        <tr key = {govHydro3.govHydro3Id}>
                                             <td>
                                                 <button onClick={ () => this.editGovHydro3(govHydro3.govHydro3Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydro3(govHydro3.govHydro3Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydro3(govHydro3.govHydro3Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydro3Component
