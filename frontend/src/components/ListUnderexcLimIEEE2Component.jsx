import React, { Component } from 'react'
import UnderexcLimIEEE2Service from '../services/UnderexcLimIEEE2Service'

class ListUnderexcLimIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                underexcLimIEEE2s: []
        }
        this.addUnderexcLimIEEE2 = this.addUnderexcLimIEEE2.bind(this);
        this.editUnderexcLimIEEE2 = this.editUnderexcLimIEEE2.bind(this);
        this.deleteUnderexcLimIEEE2 = this.deleteUnderexcLimIEEE2.bind(this);
    }

    deleteUnderexcLimIEEE2(id){
        UnderexcLimIEEE2Service.deleteUnderexcLimIEEE2(id).then( res => {
            this.setState({underexcLimIEEE2s: this.state.underexcLimIEEE2s.filter(underexcLimIEEE2 => underexcLimIEEE2.underexcLimIEEE2Id !== id)});
        });
    }
    viewUnderexcLimIEEE2(id){
        this.props.history.push(`/view-underexcLimIEEE2/${id}`);
    }
    editUnderexcLimIEEE2(id){
        this.props.history.push(`/add-underexcLimIEEE2/${id}`);
    }

    componentDidMount(){
        UnderexcLimIEEE2Service.getUnderexcLimIEEE2s().then((res) => {
            this.setState({ underexcLimIEEE2s: res.data});
        });
    }

    addUnderexcLimIEEE2(){
        this.props.history.push('/add-underexcLimIEEE2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">UnderexcLimIEEE2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnderexcLimIEEE2}> Add UnderexcLimIEEE2</button>
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
                                    this.state.underexcLimIEEE2s.map(
                                        underexcLimIEEE2 => 
                                        <tr key = {underexcLimIEEE2.underexcLimIEEE2Id}>
                                             <td>
                                                 <button onClick={ () => this.editUnderexcLimIEEE2(underexcLimIEEE2.underexcLimIEEE2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnderexcLimIEEE2(underexcLimIEEE2.underexcLimIEEE2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnderexcLimIEEE2(underexcLimIEEE2.underexcLimIEEE2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListUnderexcLimIEEE2Component
