import React, { Component } from 'react'
import ExcIEEEAC7BService from '../services/ExcIEEEAC7BService'

class ListExcIEEEAC7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEAC7Bs: []
        }
        this.addExcIEEEAC7B = this.addExcIEEEAC7B.bind(this);
        this.editExcIEEEAC7B = this.editExcIEEEAC7B.bind(this);
        this.deleteExcIEEEAC7B = this.deleteExcIEEEAC7B.bind(this);
    }

    deleteExcIEEEAC7B(id){
        ExcIEEEAC7BService.deleteExcIEEEAC7B(id).then( res => {
            this.setState({excIEEEAC7Bs: this.state.excIEEEAC7Bs.filter(excIEEEAC7B => excIEEEAC7B.excIEEEAC7BId !== id)});
        });
    }
    viewExcIEEEAC7B(id){
        this.props.history.push(`/view-excIEEEAC7B/${id}`);
    }
    editExcIEEEAC7B(id){
        this.props.history.push(`/add-excIEEEAC7B/${id}`);
    }

    componentDidMount(){
        ExcIEEEAC7BService.getExcIEEEAC7Bs().then((res) => {
            this.setState({ excIEEEAC7Bs: res.data});
        });
    }

    addExcIEEEAC7B(){
        this.props.history.push('/add-excIEEEAC7B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEAC7B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEAC7B}> Add ExcIEEEAC7B</button>
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
                                    this.state.excIEEEAC7Bs.map(
                                        excIEEEAC7B => 
                                        <tr key = {excIEEEAC7B.excIEEEAC7BId}>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEAC7B(excIEEEAC7B.excIEEEAC7BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEAC7B(excIEEEAC7B.excIEEEAC7BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEAC7B(excIEEEAC7B.excIEEEAC7BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEAC7BComponent
