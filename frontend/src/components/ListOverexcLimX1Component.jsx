import React, { Component } from 'react'
import OverexcLimX1Service from '../services/OverexcLimX1Service'

class ListOverexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                overexcLimX1s: []
        }
        this.addOverexcLimX1 = this.addOverexcLimX1.bind(this);
        this.editOverexcLimX1 = this.editOverexcLimX1.bind(this);
        this.deleteOverexcLimX1 = this.deleteOverexcLimX1.bind(this);
    }

    deleteOverexcLimX1(id){
        OverexcLimX1Service.deleteOverexcLimX1(id).then( res => {
            this.setState({overexcLimX1s: this.state.overexcLimX1s.filter(overexcLimX1 => overexcLimX1.overexcLimX1Id !== id)});
        });
    }
    viewOverexcLimX1(id){
        this.props.history.push(`/view-overexcLimX1/${id}`);
    }
    editOverexcLimX1(id){
        this.props.history.push(`/add-overexcLimX1/${id}`);
    }

    componentDidMount(){
        OverexcLimX1Service.getOverexcLimX1s().then((res) => {
            this.setState({ overexcLimX1s: res.data});
        });
    }

    addOverexcLimX1(){
        this.props.history.push('/add-overexcLimX1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OverexcLimX1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOverexcLimX1}> Add OverexcLimX1</button>
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
                                    this.state.overexcLimX1s.map(
                                        overexcLimX1 => 
                                        <tr key = {overexcLimX1.overexcLimX1Id}>
                                             <td>
                                                 <button onClick={ () => this.editOverexcLimX1(overexcLimX1.overexcLimX1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOverexcLimX1(overexcLimX1.overexcLimX1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOverexcLimX1(overexcLimX1.overexcLimX1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListOverexcLimX1Component
