import React, { Component } from 'react'
import EquivalentBranchService from '../services/EquivalentBranchService'

class ListEquivalentBranchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equivalentBranchs: []
        }
        this.addEquivalentBranch = this.addEquivalentBranch.bind(this);
        this.editEquivalentBranch = this.editEquivalentBranch.bind(this);
        this.deleteEquivalentBranch = this.deleteEquivalentBranch.bind(this);
    }

    deleteEquivalentBranch(id){
        EquivalentBranchService.deleteEquivalentBranch(id).then( res => {
            this.setState({equivalentBranchs: this.state.equivalentBranchs.filter(equivalentBranch => equivalentBranch.equivalentBranchId !== id)});
        });
    }
    viewEquivalentBranch(id){
        this.props.history.push(`/view-equivalentBranch/${id}`);
    }
    editEquivalentBranch(id){
        this.props.history.push(`/add-equivalentBranch/${id}`);
    }

    componentDidMount(){
        EquivalentBranchService.getEquivalentBranchs().then((res) => {
            this.setState({ equivalentBranchs: res.data});
        });
    }

    addEquivalentBranch(){
        this.props.history.push('/add-equivalentBranch/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquivalentBranch List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquivalentBranch}> Add EquivalentBranch</button>
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
                                    this.state.equivalentBranchs.map(
                                        equivalentBranch => 
                                        <tr key = {equivalentBranch.equivalentBranchId}>
                                             <td>
                                                 <button onClick={ () => this.editEquivalentBranch(equivalentBranch.equivalentBranchId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquivalentBranch(equivalentBranch.equivalentBranchId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquivalentBranch(equivalentBranch.equivalentBranchId)} className="btn btn-info btn-sm">View </button>
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

export default ListEquivalentBranchComponent
