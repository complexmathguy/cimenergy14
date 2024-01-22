import React, { Component } from 'react'
import ExcDC3AService from '../services/ExcDC3AService'

class ListExcDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excDC3As: []
        }
        this.addExcDC3A = this.addExcDC3A.bind(this);
        this.editExcDC3A = this.editExcDC3A.bind(this);
        this.deleteExcDC3A = this.deleteExcDC3A.bind(this);
    }

    deleteExcDC3A(id){
        ExcDC3AService.deleteExcDC3A(id).then( res => {
            this.setState({excDC3As: this.state.excDC3As.filter(excDC3A => excDC3A.excDC3AId !== id)});
        });
    }
    viewExcDC3A(id){
        this.props.history.push(`/view-excDC3A/${id}`);
    }
    editExcDC3A(id){
        this.props.history.push(`/add-excDC3A/${id}`);
    }

    componentDidMount(){
        ExcDC3AService.getExcDC3As().then((res) => {
            this.setState({ excDC3As: res.data});
        });
    }

    addExcDC3A(){
        this.props.history.push('/add-excDC3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcDC3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcDC3A}> Add ExcDC3A</button>
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
                                    this.state.excDC3As.map(
                                        excDC3A => 
                                        <tr key = {excDC3A.excDC3AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcDC3A(excDC3A.excDC3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcDC3A(excDC3A.excDC3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcDC3A(excDC3A.excDC3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcDC3AComponent
