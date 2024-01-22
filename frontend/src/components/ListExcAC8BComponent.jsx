import React, { Component } from 'react'
import ExcAC8BService from '../services/ExcAC8BService'

class ListExcAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAC8Bs: []
        }
        this.addExcAC8B = this.addExcAC8B.bind(this);
        this.editExcAC8B = this.editExcAC8B.bind(this);
        this.deleteExcAC8B = this.deleteExcAC8B.bind(this);
    }

    deleteExcAC8B(id){
        ExcAC8BService.deleteExcAC8B(id).then( res => {
            this.setState({excAC8Bs: this.state.excAC8Bs.filter(excAC8B => excAC8B.excAC8BId !== id)});
        });
    }
    viewExcAC8B(id){
        this.props.history.push(`/view-excAC8B/${id}`);
    }
    editExcAC8B(id){
        this.props.history.push(`/add-excAC8B/${id}`);
    }

    componentDidMount(){
        ExcAC8BService.getExcAC8Bs().then((res) => {
            this.setState({ excAC8Bs: res.data});
        });
    }

    addExcAC8B(){
        this.props.history.push('/add-excAC8B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAC8B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAC8B}> Add ExcAC8B</button>
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
                                    this.state.excAC8Bs.map(
                                        excAC8B => 
                                        <tr key = {excAC8B.excAC8BId}>
                                             <td>
                                                 <button onClick={ () => this.editExcAC8B(excAC8B.excAC8BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAC8B(excAC8B.excAC8BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAC8B(excAC8B.excAC8BId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAC8BComponent
