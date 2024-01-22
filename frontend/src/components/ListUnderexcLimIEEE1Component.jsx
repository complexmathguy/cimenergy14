import React, { Component } from 'react'
import UnderexcLimIEEE1Service from '../services/UnderexcLimIEEE1Service'

class ListUnderexcLimIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                underexcLimIEEE1s: []
        }
        this.addUnderexcLimIEEE1 = this.addUnderexcLimIEEE1.bind(this);
        this.editUnderexcLimIEEE1 = this.editUnderexcLimIEEE1.bind(this);
        this.deleteUnderexcLimIEEE1 = this.deleteUnderexcLimIEEE1.bind(this);
    }

    deleteUnderexcLimIEEE1(id){
        UnderexcLimIEEE1Service.deleteUnderexcLimIEEE1(id).then( res => {
            this.setState({underexcLimIEEE1s: this.state.underexcLimIEEE1s.filter(underexcLimIEEE1 => underexcLimIEEE1.underexcLimIEEE1Id !== id)});
        });
    }
    viewUnderexcLimIEEE1(id){
        this.props.history.push(`/view-underexcLimIEEE1/${id}`);
    }
    editUnderexcLimIEEE1(id){
        this.props.history.push(`/add-underexcLimIEEE1/${id}`);
    }

    componentDidMount(){
        UnderexcLimIEEE1Service.getUnderexcLimIEEE1s().then((res) => {
            this.setState({ underexcLimIEEE1s: res.data});
        });
    }

    addUnderexcLimIEEE1(){
        this.props.history.push('/add-underexcLimIEEE1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">UnderexcLimIEEE1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnderexcLimIEEE1}> Add UnderexcLimIEEE1</button>
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
                                    this.state.underexcLimIEEE1s.map(
                                        underexcLimIEEE1 => 
                                        <tr key = {underexcLimIEEE1.underexcLimIEEE1Id}>
                                             <td>
                                                 <button onClick={ () => this.editUnderexcLimIEEE1(underexcLimIEEE1.underexcLimIEEE1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnderexcLimIEEE1(underexcLimIEEE1.underexcLimIEEE1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnderexcLimIEEE1(underexcLimIEEE1.underexcLimIEEE1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListUnderexcLimIEEE1Component
