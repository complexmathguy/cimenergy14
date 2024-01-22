import React, { Component } from 'react'
import ExcDC2AService from '../services/ExcDC2AService'

class ListExcDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excDC2As: []
        }
        this.addExcDC2A = this.addExcDC2A.bind(this);
        this.editExcDC2A = this.editExcDC2A.bind(this);
        this.deleteExcDC2A = this.deleteExcDC2A.bind(this);
    }

    deleteExcDC2A(id){
        ExcDC2AService.deleteExcDC2A(id).then( res => {
            this.setState({excDC2As: this.state.excDC2As.filter(excDC2A => excDC2A.excDC2AId !== id)});
        });
    }
    viewExcDC2A(id){
        this.props.history.push(`/view-excDC2A/${id}`);
    }
    editExcDC2A(id){
        this.props.history.push(`/add-excDC2A/${id}`);
    }

    componentDidMount(){
        ExcDC2AService.getExcDC2As().then((res) => {
            this.setState({ excDC2As: res.data});
        });
    }

    addExcDC2A(){
        this.props.history.push('/add-excDC2A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcDC2A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcDC2A}> Add ExcDC2A</button>
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
                                    this.state.excDC2As.map(
                                        excDC2A => 
                                        <tr key = {excDC2A.excDC2AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcDC2A(excDC2A.excDC2AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcDC2A(excDC2A.excDC2AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcDC2A(excDC2A.excDC2AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcDC2AComponent
