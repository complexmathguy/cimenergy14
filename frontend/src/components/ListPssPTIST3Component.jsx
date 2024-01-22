import React, { Component } from 'react'
import PssPTIST3Service from '../services/PssPTIST3Service'

class ListPssPTIST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssPTIST3s: []
        }
        this.addPssPTIST3 = this.addPssPTIST3.bind(this);
        this.editPssPTIST3 = this.editPssPTIST3.bind(this);
        this.deletePssPTIST3 = this.deletePssPTIST3.bind(this);
    }

    deletePssPTIST3(id){
        PssPTIST3Service.deletePssPTIST3(id).then( res => {
            this.setState({pssPTIST3s: this.state.pssPTIST3s.filter(pssPTIST3 => pssPTIST3.pssPTIST3Id !== id)});
        });
    }
    viewPssPTIST3(id){
        this.props.history.push(`/view-pssPTIST3/${id}`);
    }
    editPssPTIST3(id){
        this.props.history.push(`/add-pssPTIST3/${id}`);
    }

    componentDidMount(){
        PssPTIST3Service.getPssPTIST3s().then((res) => {
            this.setState({ pssPTIST3s: res.data});
        });
    }

    addPssPTIST3(){
        this.props.history.push('/add-pssPTIST3/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssPTIST3 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssPTIST3}> Add PssPTIST3</button>
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
                                    this.state.pssPTIST3s.map(
                                        pssPTIST3 => 
                                        <tr key = {pssPTIST3.pssPTIST3Id}>
                                             <td>
                                                 <button onClick={ () => this.editPssPTIST3(pssPTIST3.pssPTIST3Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssPTIST3(pssPTIST3.pssPTIST3Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssPTIST3(pssPTIST3.pssPTIST3Id)} className="btn btn-info btn-sm">View </button>
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

export default ListPssPTIST3Component
