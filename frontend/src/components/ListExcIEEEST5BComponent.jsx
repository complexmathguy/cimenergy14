import React, { Component } from 'react'
import ExcIEEEST5BService from '../services/ExcIEEEST5BService'

class ListExcIEEEST5BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEST5Bs: []
        }
        this.addExcIEEEST5B = this.addExcIEEEST5B.bind(this);
        this.editExcIEEEST5B = this.editExcIEEEST5B.bind(this);
        this.deleteExcIEEEST5B = this.deleteExcIEEEST5B.bind(this);
    }

    deleteExcIEEEST5B(id){
        ExcIEEEST5BService.deleteExcIEEEST5B(id).then( res => {
            this.setState({excIEEEST5Bs: this.state.excIEEEST5Bs.filter(excIEEEST5B => excIEEEST5B.excIEEEST5BId !== id)});
        });
    }
    viewExcIEEEST5B(id){
        this.props.history.push(`/view-excIEEEST5B/${id}`);
    }
    editExcIEEEST5B(id){
        this.props.history.push(`/add-excIEEEST5B/${id}`);
    }

    componentDidMount(){
        ExcIEEEST5BService.getExcIEEEST5Bs().then((res) => {
            this.setState({ excIEEEST5Bs: res.data});
        });
    }

    addExcIEEEST5B(){
        this.props.history.push('/add-excIEEEST5B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEST5B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEST5B}> Add ExcIEEEST5B</button>
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
                                    this.state.excIEEEST5Bs.map(
                                        excIEEEST5B => 
                                        <tr key = {excIEEEST5B.excIEEEST5BId}>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEST5B(excIEEEST5B.excIEEEST5BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEST5B(excIEEEST5B.excIEEEST5BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEST5B(excIEEEST5B.excIEEEST5BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEST5BComponent
