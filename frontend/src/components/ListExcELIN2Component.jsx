import React, { Component } from 'react'
import ExcELIN2Service from '../services/ExcELIN2Service'

class ListExcELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excELIN2s: []
        }
        this.addExcELIN2 = this.addExcELIN2.bind(this);
        this.editExcELIN2 = this.editExcELIN2.bind(this);
        this.deleteExcELIN2 = this.deleteExcELIN2.bind(this);
    }

    deleteExcELIN2(id){
        ExcELIN2Service.deleteExcELIN2(id).then( res => {
            this.setState({excELIN2s: this.state.excELIN2s.filter(excELIN2 => excELIN2.excELIN2Id !== id)});
        });
    }
    viewExcELIN2(id){
        this.props.history.push(`/view-excELIN2/${id}`);
    }
    editExcELIN2(id){
        this.props.history.push(`/add-excELIN2/${id}`);
    }

    componentDidMount(){
        ExcELIN2Service.getExcELIN2s().then((res) => {
            this.setState({ excELIN2s: res.data});
        });
    }

    addExcELIN2(){
        this.props.history.push('/add-excELIN2/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcELIN2 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcELIN2}> Add ExcELIN2</button>
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
                                    this.state.excELIN2s.map(
                                        excELIN2 => 
                                        <tr key = {excELIN2.excELIN2Id}>
                                             <td>
                                                 <button onClick={ () => this.editExcELIN2(excELIN2.excELIN2Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcELIN2(excELIN2.excELIN2Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcELIN2(excELIN2.excELIN2Id)} className="btn btn-info btn-sm">View </button>
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

export default ListExcELIN2Component
