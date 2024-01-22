import React, { Component } from 'react'
import ExcIEEEST1AService from '../services/ExcIEEEST1AService'

class ListExcIEEEST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST1As: []
        }
        this.addExcIEEEST1A = this.addExcIEEEST1A.bind(this);
        this.editExcIEEEST1A = this.editExcIEEEST1A.bind(this);
        this.deleteExcIEEEST1A = this.deleteExcIEEEST1A.bind(this);
    }

    deleteExcIEEEST1A(id){
        ExcIEEEST1AService.deleteExcIEEEST1A(id).then( res => {
            this.setState({excIEEEST1As: this.state.excIEEEST1As.filter(excIEEEST1A => excIEEEST1A.excIEEEST1AId !== id)});
        });
    }
    viewExcIEEEST1A(id){
        this.props.history.push(`/view-excIEEEST1A/${id}`);
    }
    editExcIEEEST1A(id){
        this.props.history.push(`/add-excIEEEST1A/${id}`);
    }

    componentDidMount(){
        ExcIEEEST1AService.getExcIEEEST1As().then((res) => {
            this.setState({ excIEEEST1As: res.data});
        });
    }

    addExcIEEEST1A(){
        this.props.history.push('/add-excIEEEST1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST1A}> Add ExcIEEEST1A</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Uelin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excIEEEST1As.map(
                                        excIEEEST1A => 
                                        <tr key = {excIEEEST1A.excIEEEST1AId}>
                                             <td> { excIEEEST1A.uelin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST1A(excIEEEST1A.excIEEEST1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST1A(excIEEEST1A.excIEEEST1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST1A(excIEEEST1A.excIEEEST1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST1AComponent
