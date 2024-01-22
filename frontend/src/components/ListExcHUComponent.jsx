import React, { Component } from 'react'
import ExcHUService from '../services/ExcHUService'

class ListExcHUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excHUs: []
        }
        this.addExcHU = this.addExcHU.bind(this);
        this.editExcHU = this.editExcHU.bind(this);
        this.deleteExcHU = this.deleteExcHU.bind(this);
    }

    deleteExcHU(id){
        ExcHUService.deleteExcHU(id).then( res => {
            this.setState({excHUs: this.state.excHUs.filter(excHU => excHU.excHUId !== id)});
        });
    }
    viewExcHU(id){
        this.props.history.push(`/view-excHU/${id}`);
    }
    editExcHU(id){
        this.props.history.push(`/add-excHU/${id}`);
    }

    componentDidMount(){
        ExcHUService.getExcHUs().then((res) => {
            this.setState({ excHUs: res.data});
        });
    }

    addExcHU(){
        this.props.history.push('/add-excHU/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcHU List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcHU}> Add ExcHU</button>
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
                                    this.state.excHUs.map(
                                        excHU => 
                                        <tr key = {excHU.excHUId}>
                                             <td>
                                                 <button onClick={ () => this.editExcHU(excHU.excHUId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcHU(excHU.excHUId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcHU(excHU.excHUId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcHUComponent
