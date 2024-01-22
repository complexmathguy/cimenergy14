import React, { Component } from 'react'
import ExcREXSService from '../services/ExcREXSService'

class ListExcREXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excREXSs: []
        }
        this.addExcREXS = this.addExcREXS.bind(this);
        this.editExcREXS = this.editExcREXS.bind(this);
        this.deleteExcREXS = this.deleteExcREXS.bind(this);
    }

    deleteExcREXS(id){
        ExcREXSService.deleteExcREXS(id).then( res => {
            this.setState({excREXSs: this.state.excREXSs.filter(excREXS => excREXS.excREXSId !== id)});
        });
    }
    viewExcREXS(id){
        this.props.history.push(`/view-excREXS/${id}`);
    }
    editExcREXS(id){
        this.props.history.push(`/add-excREXS/${id}`);
    }

    componentDidMount(){
        ExcREXSService.getExcREXSs().then((res) => {
            this.setState({ excREXSs: res.data});
        });
    }

    addExcREXS(){
        this.props.history.push('/add-excREXS/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcREXS List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcREXS}> Add ExcREXS</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Fbf </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excREXSs.map(
                                        excREXS => 
                                        <tr key = {excREXS.excREXSId}>
                                             <td> { excREXS.fbf } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcREXS(excREXS.excREXSId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcREXS(excREXS.excREXSId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcREXS(excREXS.excREXSId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcREXSComponent
