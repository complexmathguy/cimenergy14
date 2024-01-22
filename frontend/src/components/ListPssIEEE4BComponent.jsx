import React, { Component } from 'react'
import PssIEEE4BService from '../services/PssIEEE4BService'

class ListPssIEEE4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pssIEEE4Bs: []
        }
        this.addPssIEEE4B = this.addPssIEEE4B.bind(this);
        this.editPssIEEE4B = this.editPssIEEE4B.bind(this);
        this.deletePssIEEE4B = this.deletePssIEEE4B.bind(this);
    }

    deletePssIEEE4B(id){
        PssIEEE4BService.deletePssIEEE4B(id).then( res => {
            this.setState({pssIEEE4Bs: this.state.pssIEEE4Bs.filter(pssIEEE4B => pssIEEE4B.pssIEEE4BId !== id)});
        });
    }
    viewPssIEEE4B(id){
        this.props.history.push(`/view-pssIEEE4B/${id}`);
    }
    editPssIEEE4B(id){
        this.props.history.push(`/add-pssIEEE4B/${id}`);
    }

    componentDidMount(){
        PssIEEE4BService.getPssIEEE4Bs().then((res) => {
            this.setState({ pssIEEE4Bs: res.data});
        });
    }

    addPssIEEE4B(){
        this.props.history.push('/add-pssIEEE4B/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PssIEEE4B List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPssIEEE4B}> Add PssIEEE4B</button>
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
                                    this.state.pssIEEE4Bs.map(
                                        pssIEEE4B => 
                                        <tr key = {pssIEEE4B.pssIEEE4BId}>
                                             <td>
                                                 <button onClick={ () => this.editPssIEEE4B(pssIEEE4B.pssIEEE4BId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePssIEEE4B(pssIEEE4B.pssIEEE4BId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPssIEEE4B(pssIEEE4B.pssIEEE4BId)} className="btn btn-info btn-sm">View </button>
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

export default ListPssIEEE4BComponent
