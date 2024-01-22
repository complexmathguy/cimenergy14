import React, { Component } from 'react'
import PssSKService from '../services/PssSKService'

class ListPssSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssSKs: []
        }
        this.addPssSK = this.addPssSK.bind(this);
        this.editPssSK = this.editPssSK.bind(this);
        this.deletePssSK = this.deletePssSK.bind(this);
    }

    deletePssSK(id){
        PssSKService.deletePssSK(id).then( res => {
            this.setState({pssSKs: this.state.pssSKs.filter(pssSK => pssSK.pssSKId !== id)});
        });
    }
    viewPssSK(id){
        this.props.history.push(`/view-pssSK/${id}`);
    }
    editPssSK(id){
        this.props.history.push(`/add-pssSK/${id}`);
    }

    componentDidMount(){
        PssSKService.getPssSKs().then((res) => {
            this.setState({ pssSKs: res.data});
        });
    }

    addPssSK(){
        this.props.history.push('/add-pssSK/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssSK List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssSK}> Add PssSK</button>
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
                                    this.state.pssSKs.map(
                                        pssSK => 
                                        <tr key = {pssSK.pssSKId}>
                                             <td>
                                                 <button onClick={ () => this.editPssSK(pssSK.pssSKId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssSK(pssSK.pssSKId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssSK(pssSK.pssSKId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssSKComponent
