import React, { Component } from 'react'
import ExcSKService from '../services/ExcSKService'

class ListExcSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excSKs: []
        }
        this.addExcSK = this.addExcSK.bind(this);
        this.editExcSK = this.editExcSK.bind(this);
        this.deleteExcSK = this.deleteExcSK.bind(this);
    }

    deleteExcSK(id){
        ExcSKService.deleteExcSK(id).then( res => {
            this.setState({excSKs: this.state.excSKs.filter(excSK => excSK.excSKId !== id)});
        });
    }
    viewExcSK(id){
        this.props.history.push(`/view-excSK/${id}`);
    }
    editExcSK(id){
        this.props.history.push(`/add-excSK/${id}`);
    }

    componentDidMount(){
        ExcSKService.getExcSKs().then((res) => {
            this.setState({ excSKs: res.data});
        });
    }

    addExcSK(){
        this.props.history.push('/add-excSK/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcSK List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcSK}> Add ExcSK</button>
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
                                    this.state.excSKs.map(
                                        excSK => 
                                        <tr key = {excSK.excSKId}>
                                             <td>
                                                 <button onClick={ () => this.editExcSK(excSK.excSKId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcSK(excSK.excSKId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcSK(excSK.excSKId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcSKComponent
