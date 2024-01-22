import React, { Component } from 'react'
import ExcAC3AService from '../services/ExcAC3AService'

class ListExcAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC3As: []
        }
        this.addExcAC3A = this.addExcAC3A.bind(this);
        this.editExcAC3A = this.editExcAC3A.bind(this);
        this.deleteExcAC3A = this.deleteExcAC3A.bind(this);
    }

    deleteExcAC3A(id){
        ExcAC3AService.deleteExcAC3A(id).then( res => {
            this.setState({excAC3As: this.state.excAC3As.filter(excAC3A => excAC3A.excAC3AId !== id)});
        });
    }
    viewExcAC3A(id){
        this.props.history.push(`/view-excAC3A/${id}`);
    }
    editExcAC3A(id){
        this.props.history.push(`/add-excAC3A/${id}`);
    }

    componentDidMount(){
        ExcAC3AService.getExcAC3As().then((res) => {
            this.setState({ excAC3As: res.data});
        });
    }

    addExcAC3A(){
        this.props.history.push('/add-excAC3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC3A}> Add ExcAC3A</button>
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
                                    this.state.excAC3As.map(
                                        excAC3A => 
                                        <tr key = {excAC3A.excAC3AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcAC3A(excAC3A.excAC3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC3A(excAC3A.excAC3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC3A(excAC3A.excAC3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC3AComponent
