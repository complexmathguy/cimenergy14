import React, { Component } from 'react'
import Pss2STService from '../services/Pss2STService'

class ListPss2STComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pss2STs: []
        }
        this.addPss2ST = this.addPss2ST.bind(this);
        this.editPss2ST = this.editPss2ST.bind(this);
        this.deletePss2ST = this.deletePss2ST.bind(this);
    }

    deletePss2ST(id){
        Pss2STService.deletePss2ST(id).then( res => {
            this.setState({pss2STs: this.state.pss2STs.filter(pss2ST => pss2ST.pss2STId !== id)});
        });
    }
    viewPss2ST(id){
        this.props.history.push(`/view-pss2ST/${id}`);
    }
    editPss2ST(id){
        this.props.history.push(`/add-pss2ST/${id}`);
    }

    componentDidMount(){
        Pss2STService.getPss2STs().then((res) => {
            this.setState({ pss2STs: res.data});
        });
    }

    addPss2ST(){
        this.props.history.push('/add-pss2ST/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Pss2ST List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPss2ST}> Add Pss2ST</button>
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
                                    this.state.pss2STs.map(
                                        pss2ST => 
                                        <tr key = {pss2ST.pss2STId}>
                                             <td> { pss2ST.inputSignal1Type } </td>
                                             <td> { pss2ST.inputSignal2Type } </td>
                                             <td>
                                                 <button onClick={ () => this.editPss2ST(pss2ST.pss2STId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePss2ST(pss2ST.pss2STId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPss2ST(pss2ST.pss2STId)} className="btn btn-info btn-sm">View </button>
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

export default ListPss2STComponent
