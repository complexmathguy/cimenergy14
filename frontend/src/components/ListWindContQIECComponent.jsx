import React, { Component } from 'react'
import WindContQIECService from '../services/WindContQIECService'

class ListWindContQIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContQIECs: []
        }
        this.addWindContQIEC = this.addWindContQIEC.bind(this);
        this.editWindContQIEC = this.editWindContQIEC.bind(this);
        this.deleteWindContQIEC = this.deleteWindContQIEC.bind(this);
    }

    deleteWindContQIEC(id){
        WindContQIECService.deleteWindContQIEC(id).then( res => {
            this.setState({windContQIECs: this.state.windContQIECs.filter(windContQIEC => windContQIEC.windContQIECId !== id)});
        });
    }
    viewWindContQIEC(id){
        this.props.history.push(`/view-windContQIEC/${id}`);
    }
    editWindContQIEC(id){
        this.props.history.push(`/add-windContQIEC/${id}`);
    }

    componentDidMount(){
        WindContQIECService.getWindContQIECs().then((res) => {
            this.setState({ windContQIECs: res.data});
        });
    }

    addWindContQIEC(){
        this.props.history.push('/add-windContQIEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContQIEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContQIEC}> Add WindContQIEC</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> WindLVRTQcontrolModesType </th>
                                    <th> WindQcontrolModesType </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.windContQIECs.map(
                                        windContQIEC => 
                                        <tr key = {windContQIEC.windContQIECId}>
                                             <td> { windContQIEC.windLVRTQcontrolModesType } </td>
                                             <td> { windContQIEC.windQcontrolModesType } </td>
                                             <td>
                                                 <button onClick={ () => this.editWindContQIEC(windContQIEC.windContQIECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContQIEC(windContQIEC.windContQIECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContQIEC(windContQIEC.windContQIECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContQIECComponent
