import React, { Component } from 'react'
import PowerTransformerEndService from '../services/PowerTransformerEndService'

class ListPowerTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                powerTransformerEnds: []
        }
        this.addPowerTransformerEnd = this.addPowerTransformerEnd.bind(this);
        this.editPowerTransformerEnd = this.editPowerTransformerEnd.bind(this);
        this.deletePowerTransformerEnd = this.deletePowerTransformerEnd.bind(this);
    }

    deletePowerTransformerEnd(id){
        PowerTransformerEndService.deletePowerTransformerEnd(id).then( res => {
            this.setState({powerTransformerEnds: this.state.powerTransformerEnds.filter(powerTransformerEnd => powerTransformerEnd.powerTransformerEndId !== id)});
        });
    }
    viewPowerTransformerEnd(id){
        this.props.history.push(`/view-powerTransformerEnd/${id}`);
    }
    editPowerTransformerEnd(id){
        this.props.history.push(`/add-powerTransformerEnd/${id}`);
    }

    componentDidMount(){
        PowerTransformerEndService.getPowerTransformerEnds().then((res) => {
            this.setState({ powerTransformerEnds: res.data});
        });
    }

    addPowerTransformerEnd(){
        this.props.history.push('/add-powerTransformerEnd/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PowerTransformerEnd List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPowerTransformerEnd}> Add PowerTransformerEnd</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> ConnectionKind </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.powerTransformerEnds.map(
                                        powerTransformerEnd => 
                                        <tr key = {powerTransformerEnd.powerTransformerEndId}>
                                             <td> { powerTransformerEnd.connectionKind } </td>
                                             <td>
                                                 <button onClick={ () => this.editPowerTransformerEnd(powerTransformerEnd.powerTransformerEndId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePowerTransformerEnd(powerTransformerEnd.powerTransformerEndId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPowerTransformerEnd(powerTransformerEnd.powerTransformerEndId)} className="btn btn-info btn-sm">View </button>
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

export default ListPowerTransformerEndComponent
