import React, { Component } from 'react'
import ExcAC2AService from '../services/ExcAC2AService'

class ListExcAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC2As: []
        }
        this.addExcAC2A = this.addExcAC2A.bind(this);
        this.editExcAC2A = this.editExcAC2A.bind(this);
        this.deleteExcAC2A = this.deleteExcAC2A.bind(this);
    }

    deleteExcAC2A(id){
        ExcAC2AService.deleteExcAC2A(id).then( res => {
            this.setState({excAC2As: this.state.excAC2As.filter(excAC2A => excAC2A.excAC2AId !== id)});
        });
    }
    viewExcAC2A(id){
        this.props.history.push(`/view-excAC2A/${id}`);
    }
    editExcAC2A(id){
        this.props.history.push(`/add-excAC2A/${id}`);
    }

    componentDidMount(){
        ExcAC2AService.getExcAC2As().then((res) => {
            this.setState({ excAC2As: res.data});
        });
    }

    addExcAC2A(){
        this.props.history.push('/add-excAC2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC2A}> Add ExcAC2A</button>
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
                                    this.state.excAC2As.map(
                                        excAC2A => 
                                        <tr key = {excAC2A.excAC2AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcAC2A(excAC2A.excAC2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC2A(excAC2A.excAC2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC2A(excAC2A.excAC2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC2AComponent
