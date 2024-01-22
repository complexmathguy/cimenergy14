import React, { Component } from 'react'
import ExcIEEEAC5AService from '../services/ExcIEEEAC5AService'

class ListExcIEEEAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC5As: []
        }
        this.addExcIEEEAC5A = this.addExcIEEEAC5A.bind(this);
        this.editExcIEEEAC5A = this.editExcIEEEAC5A.bind(this);
        this.deleteExcIEEEAC5A = this.deleteExcIEEEAC5A.bind(this);
    }

    deleteExcIEEEAC5A(id){
        ExcIEEEAC5AService.deleteExcIEEEAC5A(id).then( res => {
            this.setState({excIEEEAC5As: this.state.excIEEEAC5As.filter(excIEEEAC5A => excIEEEAC5A.excIEEEAC5AId !== id)});
        });
    }
    viewExcIEEEAC5A(id){
        this.props.history.push(`/view-excIEEEAC5A/${id}`);
    }
    editExcIEEEAC5A(id){
        this.props.history.push(`/add-excIEEEAC5A/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC5AService.getExcIEEEAC5As().then((res) => {
            this.setState({ excIEEEAC5As: res.data});
        });
    }

    addExcIEEEAC5A(){
        this.props.history.push('/add-excIEEEAC5A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC5A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC5A}> Add ExcIEEEAC5A</button>
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
                                    this.state.excIEEEAC5As.map(
                                        excIEEEAC5A => 
                                        <tr key = {excIEEEAC5A.excIEEEAC5AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC5A(excIEEEAC5A.excIEEEAC5AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC5A(excIEEEAC5A.excIEEEAC5AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC5A(excIEEEAC5A.excIEEEAC5AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC5AComponent
