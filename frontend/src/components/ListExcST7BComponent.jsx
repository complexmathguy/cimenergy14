import React, { Component } from 'react'
import ExcST7BService from '../services/ExcST7BService'

class ListExcST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excST7Bs: []
        }
        this.addExcST7B = this.addExcST7B.bind(this);
        this.editExcST7B = this.editExcST7B.bind(this);
        this.deleteExcST7B = this.deleteExcST7B.bind(this);
    }

    deleteExcST7B(id){
        ExcST7BService.deleteExcST7B(id).then( res => {
            this.setState({excST7Bs: this.state.excST7Bs.filter(excST7B => excST7B.excST7BId !== id)});
        });
    }
    viewExcST7B(id){
        this.props.history.push(`/view-excST7B/${id}`);
    }
    editExcST7B(id){
        this.props.history.push(`/add-excST7B/${id}`);
    }

    componentDidMount(){
        ExcST7BService.getExcST7Bs().then((res) => {
            this.setState({ excST7Bs: res.data});
        });
    }

    addExcST7B(){
        this.props.history.push('/add-excST7B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcST7B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcST7B}> Add ExcST7B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Oelin </th>
                                    <th> Uelin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excST7Bs.map(
                                        excST7B => 
                                        <tr key = {excST7B.excST7BId}>
                                             <td> { excST7B.oelin } </td>
                                             <td> { excST7B.uelin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcST7B(excST7B.excST7BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcST7B(excST7B.excST7BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcST7B(excST7B.excST7BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcST7BComponent
