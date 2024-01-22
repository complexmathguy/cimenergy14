import React, { Component } from 'react'
import ExternalNetworkInjectionService from '../services/ExternalNetworkInjectionService'

class ListExternalNetworkInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                externalNetworkInjections: []
        }
        this.addExternalNetworkInjection = this.addExternalNetworkInjection.bind(this);
        this.editExternalNetworkInjection = this.editExternalNetworkInjection.bind(this);
        this.deleteExternalNetworkInjection = this.deleteExternalNetworkInjection.bind(this);
    }

    deleteExternalNetworkInjection(id){
        ExternalNetworkInjectionService.deleteExternalNetworkInjection(id).then( res => {
            this.setState({externalNetworkInjections: this.state.externalNetworkInjections.filter(externalNetworkInjection => externalNetworkInjection.externalNetworkInjectionId !== id)});
        });
    }
    viewExternalNetworkInjection(id){
        this.props.history.push(`/view-externalNetworkInjection/${id}`);
    }
    editExternalNetworkInjection(id){
        this.props.history.push(`/add-externalNetworkInjection/${id}`);
    }

    componentDidMount(){
        ExternalNetworkInjectionService.getExternalNetworkInjections().then((res) => {
            this.setState({ externalNetworkInjections: res.data});
        });
    }

    addExternalNetworkInjection(){
        this.props.history.push('/add-externalNetworkInjection/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExternalNetworkInjection List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExternalNetworkInjection}> Add ExternalNetworkInjection</button>
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
                                    this.state.externalNetworkInjections.map(
                                        externalNetworkInjection => 
                                        <tr key = {externalNetworkInjection.externalNetworkInjectionId}>
                                             <td>
                                                 <button onClick={ () => this.editExternalNetworkInjection(externalNetworkInjection.externalNetworkInjectionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExternalNetworkInjection(externalNetworkInjection.externalNetworkInjectionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExternalNetworkInjection(externalNetworkInjection.externalNetworkInjectionId)} className="btn btn-info btn-sm">View </button>
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

export default ListExternalNetworkInjectionComponent
