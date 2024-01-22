import React, { Component } from 'react'
import ExcST6BService from '../services/ExcST6BService'

class ListExcST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excST6Bs: []
        }
        this.addExcST6B = this.addExcST6B.bind(this);
        this.editExcST6B = this.editExcST6B.bind(this);
        this.deleteExcST6B = this.deleteExcST6B.bind(this);
    }

    deleteExcST6B(id){
        ExcST6BService.deleteExcST6B(id).then( res => {
            this.setState({excST6Bs: this.state.excST6Bs.filter(excST6B => excST6B.excST6BId !== id)});
        });
    }
    viewExcST6B(id){
        this.props.history.push(`/view-excST6B/${id}`);
    }
    editExcST6B(id){
        this.props.history.push(`/add-excST6B/${id}`);
    }

    componentDidMount(){
        ExcST6BService.getExcST6Bs().then((res) => {
            this.setState({ excST6Bs: res.data});
        });
    }

    addExcST6B(){
        this.props.history.push('/add-excST6B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcST6B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcST6B}> Add ExcST6B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Oelin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excST6Bs.map(
                                        excST6B => 
                                        <tr key = {excST6B.excST6BId}>
                                             <td> { excST6B.oelin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcST6B(excST6B.excST6BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcST6B(excST6B.excST6BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcST6B(excST6B.excST6BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcST6BComponent
