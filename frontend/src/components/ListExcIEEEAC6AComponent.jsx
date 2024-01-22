import React, { Component } from 'react'
import ExcIEEEAC6AService from '../services/ExcIEEEAC6AService'

class ListExcIEEEAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC6As: []
        }
        this.addExcIEEEAC6A = this.addExcIEEEAC6A.bind(this);
        this.editExcIEEEAC6A = this.editExcIEEEAC6A.bind(this);
        this.deleteExcIEEEAC6A = this.deleteExcIEEEAC6A.bind(this);
    }

    deleteExcIEEEAC6A(id){
        ExcIEEEAC6AService.deleteExcIEEEAC6A(id).then( res => {
            this.setState({excIEEEAC6As: this.state.excIEEEAC6As.filter(excIEEEAC6A => excIEEEAC6A.excIEEEAC6AId !== id)});
        });
    }
    viewExcIEEEAC6A(id){
        this.props.history.push(`/view-excIEEEAC6A/${id}`);
    }
    editExcIEEEAC6A(id){
        this.props.history.push(`/add-excIEEEAC6A/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC6AService.getExcIEEEAC6As().then((res) => {
            this.setState({ excIEEEAC6As: res.data});
        });
    }

    addExcIEEEAC6A(){
        this.props.history.push('/add-excIEEEAC6A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC6A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC6A}> Add ExcIEEEAC6A</button>
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
                                    this.state.excIEEEAC6As.map(
                                        excIEEEAC6A => 
                                        <tr key = {excIEEEAC6A.excIEEEAC6AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC6A(excIEEEAC6A.excIEEEAC6AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC6A(excIEEEAC6A.excIEEEAC6AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC6A(excIEEEAC6A.excIEEEAC6AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC6AComponent
