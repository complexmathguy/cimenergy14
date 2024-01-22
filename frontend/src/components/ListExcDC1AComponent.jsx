import React, { Component } from 'react'
import ExcDC1AService from '../services/ExcDC1AService'

class ListExcDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excDC1As: []
        }
        this.addExcDC1A = this.addExcDC1A.bind(this);
        this.editExcDC1A = this.editExcDC1A.bind(this);
        this.deleteExcDC1A = this.deleteExcDC1A.bind(this);
    }

    deleteExcDC1A(id){
        ExcDC1AService.deleteExcDC1A(id).then( res => {
            this.setState({excDC1As: this.state.excDC1As.filter(excDC1A => excDC1A.excDC1AId !== id)});
        });
    }
    viewExcDC1A(id){
        this.props.history.push(`/view-excDC1A/${id}`);
    }
    editExcDC1A(id){
        this.props.history.push(`/add-excDC1A/${id}`);
    }

    componentDidMount(){
        ExcDC1AService.getExcDC1As().then((res) => {
            this.setState({ excDC1As: res.data});
        });
    }

    addExcDC1A(){
        this.props.history.push('/add-excDC1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcDC1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcDC1A}> Add ExcDC1A</button>
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
                                    this.state.excDC1As.map(
                                        excDC1A => 
                                        <tr key = {excDC1A.excDC1AId}>
                                             <td>
                                                 <button onClick={ () => this.editExcDC1A(excDC1A.excDC1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcDC1A(excDC1A.excDC1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcDC1A(excDC1A.excDC1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcDC1AComponent
