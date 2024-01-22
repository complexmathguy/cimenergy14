import React, { Component } from 'react'
import EquivalentInjectionService from '../services/EquivalentInjectionService'

class ListEquivalentInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equivalentInjections: []
        }
        this.addEquivalentInjection = this.addEquivalentInjection.bind(this);
        this.editEquivalentInjection = this.editEquivalentInjection.bind(this);
        this.deleteEquivalentInjection = this.deleteEquivalentInjection.bind(this);
    }

    deleteEquivalentInjection(id){
        EquivalentInjectionService.deleteEquivalentInjection(id).then( res => {
            this.setState({equivalentInjections: this.state.equivalentInjections.filter(equivalentInjection => equivalentInjection.equivalentInjectionId !== id)});
        });
    }
    viewEquivalentInjection(id){
        this.props.history.push(`/view-equivalentInjection/${id}`);
    }
    editEquivalentInjection(id){
        this.props.history.push(`/add-equivalentInjection/${id}`);
    }

    componentDidMount(){
        EquivalentInjectionService.getEquivalentInjections().then((res) => {
            this.setState({ equivalentInjections: res.data});
        });
    }

    addEquivalentInjection(){
        this.props.history.push('/add-equivalentInjection/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquivalentInjection List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquivalentInjection}> Add EquivalentInjection</button>
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
                                    this.state.equivalentInjections.map(
                                        equivalentInjection => 
                                        <tr key = {equivalentInjection.equivalentInjectionId}>
                                             <td>
                                                 <button onClick={ () => this.editEquivalentInjection(equivalentInjection.equivalentInjectionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquivalentInjection(equivalentInjection.equivalentInjectionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquivalentInjection(equivalentInjection.equivalentInjectionId)} className="btn btn-info btn-sm">View </button>
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

export default ListEquivalentInjectionComponent
