import React, { Component } from 'react'
import Pss2BService from '../services/Pss2BService'

class ListPss2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pss2Bs: []
        }
        this.addPss2B = this.addPss2B.bind(this);
        this.editPss2B = this.editPss2B.bind(this);
        this.deletePss2B = this.deletePss2B.bind(this);
    }

    deletePss2B(id){
        Pss2BService.deletePss2B(id).then( res => {
            this.setState({pss2Bs: this.state.pss2Bs.filter(pss2B => pss2B.pss2BId !== id)});
        });
    }
    viewPss2B(id){
        this.props.history.push(`/view-pss2B/${id}`);
    }
    editPss2B(id){
        this.props.history.push(`/add-pss2B/${id}`);
    }

    componentDidMount(){
        Pss2BService.getPss2Bs().then((res) => {
            this.setState({ pss2Bs: res.data});
        });
    }

    addPss2B(){
        this.props.history.push('/add-pss2B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Pss2B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPss2B}> Add Pss2B</button>
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
                                    this.state.pss2Bs.map(
                                        pss2B => 
                                        <tr key = {pss2B.pss2BId}>
                                             <td> { pss2B.inputSignal1Type } </td>
                                             <td> { pss2B.inputSignal2Type } </td>
                                             <td>
                                                 <button onClick={ () => this.editPss2B(pss2B.pss2BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePss2B(pss2B.pss2BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPss2B(pss2B.pss2BId)} className="btn btn-info btn-sm">View </button>
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

export default ListPss2BComponent
