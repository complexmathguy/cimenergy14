import React, { Component } from 'react'
import ExternalNetworkInjectionService from '../services/ExternalNetworkInjectionService';

class UpdateExternalNetworkInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExternalNetworkInjection = this.updateExternalNetworkInjection.bind(this);

    }

    componentDidMount(){
        ExternalNetworkInjectionService.getExternalNetworkInjectionById(this.state.id).then( (res) =>{
            let externalNetworkInjection = res.data;
            this.setState({
            });
        });
    }

    updateExternalNetworkInjection = (e) => {
        e.preventDefault();
        let externalNetworkInjection = {
            externalNetworkInjectionId: this.state.id,
        };
        console.log('externalNetworkInjection => ' + JSON.stringify(externalNetworkInjection));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExternalNetworkInjectionService.updateExternalNetworkInjection(externalNetworkInjection).then( res => {
            this.props.history.push('/externalNetworkInjections');
        });
    }


    cancel(){
        this.props.history.push('/externalNetworkInjections');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExternalNetworkInjection</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExternalNetworkInjection}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateExternalNetworkInjectionComponent
