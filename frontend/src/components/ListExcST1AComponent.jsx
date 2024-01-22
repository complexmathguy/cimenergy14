import React, { Component } from 'react'
import ExcST1AService from '../services/ExcST1AService'

class ListExcST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excST1As: []
        }
        this.addExcST1A = this.addExcST1A.bind(this);
        this.editExcST1A = this.editExcST1A.bind(this);
        this.deleteExcST1A = this.deleteExcST1A.bind(this);
    }

    deleteExcST1A(id){
        ExcST1AService.deleteExcST1A(id).then( res => {
            this.setState({excST1As: this.state.excST1As.filter(excST1A => excST1A.excST1AId !== id)});
        });
    }
    viewExcST1A(id){
        this.props.history.push(`/view-excST1A/${id}`);
    }
    editExcST1A(id){
        this.props.history.push(`/add-excST1A/${id}`);
    }

    componentDidMount(){
        ExcST1AService.getExcST1As().then((res) => {
            this.setState({ excST1As: res.data});
        });
    }

    addExcST1A(){
        this.props.history.push('/add-excST1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcST1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcST1A}> Add ExcST1A</button>
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
                                    this.state.excST1As.map(
                                        excST1A => 
                                        <tr key = {excST1A.excST1AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcST1A(excST1A.excST1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcST1A(excST1A.excST1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcST1A(excST1A.excST1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcST1AComponent
