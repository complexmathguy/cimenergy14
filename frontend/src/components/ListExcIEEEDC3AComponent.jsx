import React, { Component } from 'react'
import ExcIEEEDC3AService from '../services/ExcIEEEDC3AService'

class ListExcIEEEDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excIEEEDC3As: []
        }
        this.addExcIEEEDC3A = this.addExcIEEEDC3A.bind(this);
        this.editExcIEEEDC3A = this.editExcIEEEDC3A.bind(this);
        this.deleteExcIEEEDC3A = this.deleteExcIEEEDC3A.bind(this);
    }

    deleteExcIEEEDC3A(id){
        ExcIEEEDC3AService.deleteExcIEEEDC3A(id).then( res => {
            this.setState({excIEEEDC3As: this.state.excIEEEDC3As.filter(excIEEEDC3A => excIEEEDC3A.excIEEEDC3AId !== id)});
        });
    }
    viewExcIEEEDC3A(id){
        this.props.history.push(`/view-excIEEEDC3A/${id}`);
    }
    editExcIEEEDC3A(id){
        this.props.history.push(`/add-excIEEEDC3A/${id}`);
    }

    componentDidMount(){
        ExcIEEEDC3AService.getExcIEEEDC3As().then((res) => {
            this.setState({ excIEEEDC3As: res.data});
        });
    }

    addExcIEEEDC3A(){
        this.props.history.push('/add-excIEEEDC3A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcIEEEDC3A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcIEEEDC3A}> Add ExcIEEEDC3A</button>
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
                                    this.state.excIEEEDC3As.map(
                                        excIEEEDC3A => 
                                        <tr key = {excIEEEDC3A.excIEEEDC3AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcIEEEDC3A(excIEEEDC3A.excIEEEDC3AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcIEEEDC3A(excIEEEDC3A.excIEEEDC3AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcIEEEDC3A(excIEEEDC3A.excIEEEDC3AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcIEEEDC3AComponent
