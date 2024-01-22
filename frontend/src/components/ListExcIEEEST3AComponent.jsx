import React, { Component } from 'react'
import ExcIEEEST3AService from '../services/ExcIEEEST3AService'

class ListExcIEEEST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST3As: []
        }
        this.addExcIEEEST3A = this.addExcIEEEST3A.bind(this);
        this.editExcIEEEST3A = this.editExcIEEEST3A.bind(this);
        this.deleteExcIEEEST3A = this.deleteExcIEEEST3A.bind(this);
    }

    deleteExcIEEEST3A(id){
        ExcIEEEST3AService.deleteExcIEEEST3A(id).then( res => {
            this.setState({excIEEEST3As: this.state.excIEEEST3As.filter(excIEEEST3A => excIEEEST3A.excIEEEST3AId !== id)});
        });
    }
    viewExcIEEEST3A(id){
        this.props.history.push(`/view-excIEEEST3A/${id}`);
    }
    editExcIEEEST3A(id){
        this.props.history.push(`/add-excIEEEST3A/${id}`);
    }

    componentDidMount(){
        ExcIEEEST3AService.getExcIEEEST3As().then((res) => {
            this.setState({ excIEEEST3As: res.data});
        });
    }

    addExcIEEEST3A(){
        this.props.history.push('/add-excIEEEST3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST3A}> Add ExcIEEEST3A</button>
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
                                    this.state.excIEEEST3As.map(
                                        excIEEEST3A => 
                                        <tr key = {excIEEEST3A.excIEEEST3AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST3A(excIEEEST3A.excIEEEST3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST3A(excIEEEST3A.excIEEEST3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST3A(excIEEEST3A.excIEEEST3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST3AComponent
