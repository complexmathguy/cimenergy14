import React, { Component } from 'react'
import ExcST3AService from '../services/ExcST3AService'

class ListExcST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excST3As: []
        }
        this.addExcST3A = this.addExcST3A.bind(this);
        this.editExcST3A = this.editExcST3A.bind(this);
        this.deleteExcST3A = this.deleteExcST3A.bind(this);
    }

    deleteExcST3A(id){
        ExcST3AService.deleteExcST3A(id).then( res => {
            this.setState({excST3As: this.state.excST3As.filter(excST3A => excST3A.excST3AId !== id)});
        });
    }
    viewExcST3A(id){
        this.props.history.push(`/view-excST3A/${id}`);
    }
    editExcST3A(id){
        this.props.history.push(`/add-excST3A/${id}`);
    }

    componentDidMount(){
        ExcST3AService.getExcST3As().then((res) => {
            this.setState({ excST3As: res.data});
        });
    }

    addExcST3A(){
        this.props.history.push('/add-excST3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcST3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcST3A}> Add ExcST3A</button>
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
                                    this.state.excST3As.map(
                                        excST3A => 
                                        <tr key = {excST3A.excST3AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcST3A(excST3A.excST3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcST3A(excST3A.excST3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcST3A(excST3A.excST3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcST3AComponent
