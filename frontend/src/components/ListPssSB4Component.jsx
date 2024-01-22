import React, { Component } from 'react'
import PssSB4Service from '../services/PssSB4Service'

class ListPssSB4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssSB4s: []
        }
        this.addPssSB4 = this.addPssSB4.bind(this);
        this.editPssSB4 = this.editPssSB4.bind(this);
        this.deletePssSB4 = this.deletePssSB4.bind(this);
    }

    deletePssSB4(id){
        PssSB4Service.deletePssSB4(id).then( res => {
            this.setState({pssSB4s: this.state.pssSB4s.filter(pssSB4 => pssSB4.pssSB4Id !== id)});
        });
    }
    viewPssSB4(id){
        this.props.history.push(`/view-pssSB4/${id}`);
    }
    editPssSB4(id){
        this.props.history.push(`/add-pssSB4/${id}`);
    }

    componentDidMount(){
        PssSB4Service.getPssSB4s().then((res) => {
            this.setState({ pssSB4s: res.data});
        });
    }

    addPssSB4(){
        this.props.history.push('/add-pssSB4/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssSB4 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssSB4}> Add PssSB4</button>
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
                                    this.state.pssSB4s.map(
                                        pssSB4 => 
                                        <tr key = {pssSB4.pssSB4Id}>
                                             <td>
                                                 <button onClick={ () => this.editPssSB4(pssSB4.pssSB4Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssSB4(pssSB4.pssSB4Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssSB4(pssSB4.pssSB4Id)} className="btn btn-info btn-sm">View </button>
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

export default ListPssSB4Component
