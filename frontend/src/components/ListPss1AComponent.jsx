import React, { Component } from 'react'
import Pss1AService from '../services/Pss1AService'

class ListPss1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pss1As: []
        }
        this.addPss1A = this.addPss1A.bind(this);
        this.editPss1A = this.editPss1A.bind(this);
        this.deletePss1A = this.deletePss1A.bind(this);
    }

    deletePss1A(id){
        Pss1AService.deletePss1A(id).then( res => {
            this.setState({pss1As: this.state.pss1As.filter(pss1A => pss1A.pss1AId !== id)});
        });
    }
    viewPss1A(id){
        this.props.history.push(`/view-pss1A/${id}`);
    }
    editPss1A(id){
        this.props.history.push(`/add-pss1A/${id}`);
    }

    componentDidMount(){
        Pss1AService.getPss1As().then((res) => {
            this.setState({ pss1As: res.data});
        });
    }

    addPss1A(){
        this.props.history.push('/add-pss1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Pss1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPss1A}> Add Pss1A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> InputSignalType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pss1As.map(
                                        pss1A => 
                                        <tr key = {pss1A.pss1AId}>
                                             <td> { pss1A.inputSignalType } </td>
                                             <td>
                                                 <button onClick={ () => this.editPss1A(pss1A.pss1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePss1A(pss1A.pss1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPss1A(pss1A.pss1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListPss1AComponent
