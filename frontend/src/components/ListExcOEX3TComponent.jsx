import React, { Component } from 'react'
import ExcOEX3TService from '../services/ExcOEX3TService'

class ListExcOEX3TComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excOEX3Ts: []
        }
        this.addExcOEX3T = this.addExcOEX3T.bind(this);
        this.editExcOEX3T = this.editExcOEX3T.bind(this);
        this.deleteExcOEX3T = this.deleteExcOEX3T.bind(this);
    }

    deleteExcOEX3T(id){
        ExcOEX3TService.deleteExcOEX3T(id).then( res => {
            this.setState({excOEX3Ts: this.state.excOEX3Ts.filter(excOEX3T => excOEX3T.excOEX3TId !== id)});
        });
    }
    viewExcOEX3T(id){
        this.props.history.push(`/view-excOEX3T/${id}`);
    }
    editExcOEX3T(id){
        this.props.history.push(`/add-excOEX3T/${id}`);
    }

    componentDidMount(){
        ExcOEX3TService.getExcOEX3Ts().then((res) => {
            this.setState({ excOEX3Ts: res.data});
        });
    }

    addExcOEX3T(){
        this.props.history.push('/add-excOEX3T/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcOEX3T List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcOEX3T}> Add ExcOEX3T</button>
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
                                    this.state.excOEX3Ts.map(
                                        excOEX3T => 
                                        <tr key = {excOEX3T.excOEX3TId}>
                                             <td>
                                                 <button onClick={ () => this.editExcOEX3T(excOEX3T.excOEX3TId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcOEX3T(excOEX3T.excOEX3TId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcOEX3T(excOEX3T.excOEX3TId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcOEX3TComponent
