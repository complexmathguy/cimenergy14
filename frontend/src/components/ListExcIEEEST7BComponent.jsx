import React, { Component } from 'react'
import ExcIEEEST7BService from '../services/ExcIEEEST7BService'

class ListExcIEEEST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST7Bs: []
        }
        this.addExcIEEEST7B = this.addExcIEEEST7B.bind(this);
        this.editExcIEEEST7B = this.editExcIEEEST7B.bind(this);
        this.deleteExcIEEEST7B = this.deleteExcIEEEST7B.bind(this);
    }

    deleteExcIEEEST7B(id){
        ExcIEEEST7BService.deleteExcIEEEST7B(id).then( res => {
            this.setState({excIEEEST7Bs: this.state.excIEEEST7Bs.filter(excIEEEST7B => excIEEEST7B.excIEEEST7BId !== id)});
        });
    }
    viewExcIEEEST7B(id){
        this.props.history.push(`/view-excIEEEST7B/${id}`);
    }
    editExcIEEEST7B(id){
        this.props.history.push(`/add-excIEEEST7B/${id}`);
    }

    componentDidMount(){
        ExcIEEEST7BService.getExcIEEEST7Bs().then((res) => {
            this.setState({ excIEEEST7Bs: res.data});
        });
    }

    addExcIEEEST7B(){
        this.props.history.push('/add-excIEEEST7B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST7B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST7B}> Add ExcIEEEST7B</button>
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
                                    this.state.excIEEEST7Bs.map(
                                        excIEEEST7B => 
                                        <tr key = {excIEEEST7B.excIEEEST7BId}>
                                             <td> { excIEEEST7B.oelin } </td>
                                             <td> { excIEEEST7B.uelin } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST7B(excIEEEST7B.excIEEEST7BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST7B(excIEEEST7B.excIEEEST7BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST7B(excIEEEST7B.excIEEEST7BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST7BComponent
