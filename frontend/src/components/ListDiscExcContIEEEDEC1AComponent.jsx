import React, { Component } from 'react'
import DiscExcContIEEEDEC1AService from '../services/DiscExcContIEEEDEC1AService'

class ListDiscExcContIEEEDEC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                discExcContIEEEDEC1As: []
        }
        this.addDiscExcContIEEEDEC1A = this.addDiscExcContIEEEDEC1A.bind(this);
        this.editDiscExcContIEEEDEC1A = this.editDiscExcContIEEEDEC1A.bind(this);
        this.deleteDiscExcContIEEEDEC1A = this.deleteDiscExcContIEEEDEC1A.bind(this);
    }

    deleteDiscExcContIEEEDEC1A(id){
        DiscExcContIEEEDEC1AService.deleteDiscExcContIEEEDEC1A(id).then( res => {
            this.setState({discExcContIEEEDEC1As: this.state.discExcContIEEEDEC1As.filter(discExcContIEEEDEC1A => discExcContIEEEDEC1A.discExcContIEEEDEC1AId !== id)});
        });
    }
    viewDiscExcContIEEEDEC1A(id){
        this.props.history.push(`/view-discExcContIEEEDEC1A/${id}`);
    }
    editDiscExcContIEEEDEC1A(id){
        this.props.history.push(`/add-discExcContIEEEDEC1A/${id}`);
    }

    componentDidMount(){
        DiscExcContIEEEDEC1AService.getDiscExcContIEEEDEC1As().then((res) => {
            this.setState({ discExcContIEEEDEC1As: res.data});
        });
    }

    addDiscExcContIEEEDEC1A(){
        this.props.history.push('/add-discExcContIEEEDEC1A/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiscExcContIEEEDEC1A List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiscExcContIEEEDEC1A}> Add DiscExcContIEEEDEC1A</button>
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
                                    this.state.discExcContIEEEDEC1As.map(
                                        discExcContIEEEDEC1A => 
                                        <tr key = {discExcContIEEEDEC1A.discExcContIEEEDEC1AId}>
                                             <td>
                                                 <button onClick={ () => this.editDiscExcContIEEEDEC1A(discExcContIEEEDEC1A.discExcContIEEEDEC1AId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiscExcContIEEEDEC1A(discExcContIEEEDEC1A.discExcContIEEEDEC1AId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiscExcContIEEEDEC1A(discExcContIEEEDEC1A.discExcContIEEEDEC1AId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiscExcContIEEEDEC1AComponent
