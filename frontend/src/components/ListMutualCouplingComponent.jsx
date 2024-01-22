import React, { Component } from 'react'
import MutualCouplingService from '../services/MutualCouplingService'

class ListMutualCouplingComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                mutualCouplings: []
        }
        this.addMutualCoupling = this.addMutualCoupling.bind(this);
        this.editMutualCoupling = this.editMutualCoupling.bind(this);
        this.deleteMutualCoupling = this.deleteMutualCoupling.bind(this);
    }

    deleteMutualCoupling(id){
        MutualCouplingService.deleteMutualCoupling(id).then( res => {
            this.setState({mutualCouplings: this.state.mutualCouplings.filter(mutualCoupling => mutualCoupling.mutualCouplingId !== id)});
        });
    }
    viewMutualCoupling(id){
        this.props.history.push(`/view-mutualCoupling/${id}`);
    }
    editMutualCoupling(id){
        this.props.history.push(`/add-mutualCoupling/${id}`);
    }

    componentDidMount(){
        MutualCouplingService.getMutualCouplings().then((res) => {
            this.setState({ mutualCouplings: res.data});
        });
    }

    addMutualCoupling(){
        this.props.history.push('/add-mutualCoupling/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MutualCoupling List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMutualCoupling}> Add MutualCoupling</button>
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
                                    this.state.mutualCouplings.map(
                                        mutualCoupling => 
                                        <tr key = {mutualCoupling.mutualCouplingId}>
                                             <td>
                                                 <button onClick={ () => this.editMutualCoupling(mutualCoupling.mutualCouplingId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMutualCoupling(mutualCoupling.mutualCouplingId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMutualCoupling(mutualCoupling.mutualCouplingId)} className="btn btn-info btn-sm">View </button>
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

export default ListMutualCouplingComponent
