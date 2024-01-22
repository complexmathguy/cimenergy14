import React, { Component } from 'react'
import ExcAC5AService from '../services/ExcAC5AService'

class ListExcAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC5As: []
        }
        this.addExcAC5A = this.addExcAC5A.bind(this);
        this.editExcAC5A = this.editExcAC5A.bind(this);
        this.deleteExcAC5A = this.deleteExcAC5A.bind(this);
    }

    deleteExcAC5A(id){
        ExcAC5AService.deleteExcAC5A(id).then( res => {
            this.setState({excAC5As: this.state.excAC5As.filter(excAC5A => excAC5A.excAC5AId !== id)});
        });
    }
    viewExcAC5A(id){
        this.props.history.push(`/view-excAC5A/${id}`);
    }
    editExcAC5A(id){
        this.props.history.push(`/add-excAC5A/${id}`);
    }

    componentDidMount(){
        ExcAC5AService.getExcAC5As().then((res) => {
            this.setState({ excAC5As: res.data});
        });
    }

    addExcAC5A(){
        this.props.history.push('/add-excAC5A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC5A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC5A}> Add ExcAC5A</button>
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
                                    this.state.excAC5As.map(
                                        excAC5A => 
                                        <tr key = {excAC5A.excAC5AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcAC5A(excAC5A.excAC5AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC5A(excAC5A.excAC5AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC5A(excAC5A.excAC5AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC5AComponent
