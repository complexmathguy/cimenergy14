import React, { Component } from 'react'
import PssIEEE3BService from '../services/PssIEEE3BService'

class ListPssIEEE3BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssIEEE3Bs: []
        }
        this.addPssIEEE3B = this.addPssIEEE3B.bind(this);
        this.editPssIEEE3B = this.editPssIEEE3B.bind(this);
        this.deletePssIEEE3B = this.deletePssIEEE3B.bind(this);
    }

    deletePssIEEE3B(id){
        PssIEEE3BService.deletePssIEEE3B(id).then( res => {
            this.setState({pssIEEE3Bs: this.state.pssIEEE3Bs.filter(pssIEEE3B => pssIEEE3B.pssIEEE3BId !== id)});
        });
    }
    viewPssIEEE3B(id){
        this.props.history.push(`/view-pssIEEE3B/${id}`);
    }
    editPssIEEE3B(id){
        this.props.history.push(`/add-pssIEEE3B/${id}`);
    }

    componentDidMount(){
        PssIEEE3BService.getPssIEEE3Bs().then((res) => {
            this.setState({ pssIEEE3Bs: res.data});
        });
    }

    addPssIEEE3B(){
        this.props.history.push('/add-pssIEEE3B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssIEEE3B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssIEEE3B}> Add PssIEEE3B</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> InputSignal1Type </th>
                                    <th> InputSignal2Type </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pssIEEE3Bs.map(
                                        pssIEEE3B => 
                                        <tr key = {pssIEEE3B.pssIEEE3BId}>
                                             <td> { pssIEEE3B.inputSignal1Type } </td>
                                             <td> { pssIEEE3B.inputSignal2Type } </td>
                                             <td>
                                                 <button onClick={ () => this.editPssIEEE3B(pssIEEE3B.pssIEEE3BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssIEEE3B(pssIEEE3B.pssIEEE3BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssIEEE3B(pssIEEE3B.pssIEEE3BId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssIEEE3BComponent
