import React, { Component } from 'react'
import ExcAVR7Service from '../services/ExcAVR7Service'

class ListExcAVR7Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excAVR7s: []
        }
        this.addExcAVR7 = this.addExcAVR7.bind(this);
        this.editExcAVR7 = this.editExcAVR7.bind(this);
        this.deleteExcAVR7 = this.deleteExcAVR7.bind(this);
    }

    deleteExcAVR7(id){
        ExcAVR7Service.deleteExcAVR7(id).then( res => {
            this.setState({excAVR7s: this.state.excAVR7s.filter(excAVR7 => excAVR7.excAVR7Id !== id)});
        });
    }
    viewExcAVR7(id){
        this.props.history.push(`/view-excAVR7/${id}`);
    }
    editExcAVR7(id){
        this.props.history.push(`/add-excAVR7/${id}`);
    }

    componentDidMount(){
        ExcAVR7Service.getExcAVR7s().then((res) => {
            this.setState({ excAVR7s: res.data});
        });
    }

    addExcAVR7(){
        this.props.history.push('/add-excAVR7/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcAVR7 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcAVR7}> Add ExcAVR7</button>
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
                                    this.state.excAVR7s.map(
                                        excAVR7 => 
                                        <tr key = {excAVR7.excAVR7Id}>
                                             <td>
                                                 <button onClick={ () => this.editExcAVR7(excAVR7.excAVR7Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcAVR7(excAVR7.excAVR7Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcAVR7(excAVR7.excAVR7Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcAVR7Component
