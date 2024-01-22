import React, { Component } from 'react'
import ExcPICService from '../services/ExcPICService'

class ListExcPICComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excPICs: []
        }
        this.addExcPIC = this.addExcPIC.bind(this);
        this.editExcPIC = this.editExcPIC.bind(this);
        this.deleteExcPIC = this.deleteExcPIC.bind(this);
    }

    deleteExcPIC(id){
        ExcPICService.deleteExcPIC(id).then( res => {
            this.setState({excPICs: this.state.excPICs.filter(excPIC => excPIC.excPICId !== id)});
        });
    }
    viewExcPIC(id){
        this.props.history.push(`/view-excPIC/${id}`);
    }
    editExcPIC(id){
        this.props.history.push(`/add-excPIC/${id}`);
    }

    componentDidMount(){
        ExcPICService.getExcPICs().then((res) => {
            this.setState({ excPICs: res.data});
        });
    }

    addExcPIC(){
        this.props.history.push('/add-excPIC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcPIC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcPIC}> Add ExcPIC</button>
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
                                    this.state.excPICs.map(
                                        excPIC => 
                                        <tr key = {excPIC.excPICId}>
                                             <td>
                                                 <button onClick={ () => this.editExcPIC(excPIC.excPICId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcPIC(excPIC.excPICId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcPIC(excPIC.excPICId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcPICComponent
