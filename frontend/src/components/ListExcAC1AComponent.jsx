import React, { Component } from 'react'
import ExcAC1AService from '../services/ExcAC1AService'

class ListExcAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC1As: []
        }
        this.addExcAC1A = this.addExcAC1A.bind(this);
        this.editExcAC1A = this.editExcAC1A.bind(this);
        this.deleteExcAC1A = this.deleteExcAC1A.bind(this);
    }

    deleteExcAC1A(id){
        ExcAC1AService.deleteExcAC1A(id).then( res => {
            this.setState({excAC1As: this.state.excAC1As.filter(excAC1A => excAC1A.excAC1AId !== id)});
        });
    }
    viewExcAC1A(id){
        this.props.history.push(`/view-excAC1A/${id}`);
    }
    editExcAC1A(id){
        this.props.history.push(`/add-excAC1A/${id}`);
    }

    componentDidMount(){
        ExcAC1AService.getExcAC1As().then((res) => {
            this.setState({ excAC1As: res.data});
        });
    }

    addExcAC1A(){
        this.props.history.push('/add-excAC1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC1A}> Add ExcAC1A</button>
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
                                    this.state.excAC1As.map(
                                        excAC1A => 
                                        <tr key = {excAC1A.excAC1AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcAC1A(excAC1A.excAC1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC1A(excAC1A.excAC1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC1A(excAC1A.excAC1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC1AComponent
