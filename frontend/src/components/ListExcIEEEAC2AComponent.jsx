import React, { Component } from 'react'
import ExcIEEEAC2AService from '../services/ExcIEEEAC2AService'

class ListExcIEEEAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC2As: []
        }
        this.addExcIEEEAC2A = this.addExcIEEEAC2A.bind(this);
        this.editExcIEEEAC2A = this.editExcIEEEAC2A.bind(this);
        this.deleteExcIEEEAC2A = this.deleteExcIEEEAC2A.bind(this);
    }

    deleteExcIEEEAC2A(id){
        ExcIEEEAC2AService.deleteExcIEEEAC2A(id).then( res => {
            this.setState({excIEEEAC2As: this.state.excIEEEAC2As.filter(excIEEEAC2A => excIEEEAC2A.excIEEEAC2AId !== id)});
        });
    }
    viewExcIEEEAC2A(id){
        this.props.history.push(`/view-excIEEEAC2A/${id}`);
    }
    editExcIEEEAC2A(id){
        this.props.history.push(`/add-excIEEEAC2A/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC2AService.getExcIEEEAC2As().then((res) => {
            this.setState({ excIEEEAC2As: res.data});
        });
    }

    addExcIEEEAC2A(){
        this.props.history.push('/add-excIEEEAC2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC2A}> Add ExcIEEEAC2A</button>
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
                                    this.state.excIEEEAC2As.map(
                                        excIEEEAC2A => 
                                        <tr key = {excIEEEAC2A.excIEEEAC2AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC2A(excIEEEAC2A.excIEEEAC2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC2A(excIEEEAC2A.excIEEEAC2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC2A(excIEEEAC2A.excIEEEAC2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC2AComponent
