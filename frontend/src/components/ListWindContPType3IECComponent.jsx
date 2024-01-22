import React, { Component } from 'react'
import WindContPType3IECService from '../services/WindContPType3IECService'

class ListWindContPType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                windContPType3IECs: []
        }
        this.addWindContPType3IEC = this.addWindContPType3IEC.bind(this);
        this.editWindContPType3IEC = this.editWindContPType3IEC.bind(this);
        this.deleteWindContPType3IEC = this.deleteWindContPType3IEC.bind(this);
    }

    deleteWindContPType3IEC(id){
        WindContPType3IECService.deleteWindContPType3IEC(id).then( res => {
            this.setState({windContPType3IECs: this.state.windContPType3IECs.filter(windContPType3IEC => windContPType3IEC.windContPType3IECId !== id)});
        });
    }
    viewWindContPType3IEC(id){
        this.props.history.push(`/view-windContPType3IEC/${id}`);
    }
    editWindContPType3IEC(id){
        this.props.history.push(`/add-windContPType3IEC/${id}`);
    }

    componentDidMount(){
        WindContPType3IECService.getWindContPType3IECs().then((res) => {
            this.setState({ windContPType3IECs: res.data});
        });
    }

    addWindContPType3IEC(){
        this.props.history.push('/add-windContPType3IEC/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">WindContPType3IEC List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addWindContPType3IEC}> Add WindContPType3IEC</button>
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
                                    this.state.windContPType3IECs.map(
                                        windContPType3IEC => 
                                        <tr key = {windContPType3IEC.windContPType3IECId}>
                                             <td>
                                                 <button onClick={ () => this.editWindContPType3IEC(windContPType3IEC.windContPType3IECId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteWindContPType3IEC(windContPType3IEC.windContPType3IECId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewWindContPType3IEC(windContPType3IEC.windContPType3IECId)} className="btn btn-info btn-sm">View </button>
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

export default ListWindContPType3IECComponent
