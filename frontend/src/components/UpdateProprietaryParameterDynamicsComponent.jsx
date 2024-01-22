import React, { Component } from 'react'
import ProprietaryParameterDynamicsService from '../services/ProprietaryParameterDynamicsService';

class UpdateProprietaryParameterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateProprietaryParameterDynamics = this.updateProprietaryParameterDynamics.bind(this);

    }

    componentDidMount(){
        ProprietaryParameterDynamicsService.getProprietaryParameterDynamicsById(this.state.id).then( (res) =>{
            let proprietaryParameterDynamics = res.data;
            this.setState({
            });
        });
    }

    updateProprietaryParameterDynamics = (e) => {
        e.preventDefault();
        let proprietaryParameterDynamics = {
            proprietaryParameterDynamicsId: this.state.id,
        };
        console.log('proprietaryParameterDynamics => ' + JSON.stringify(proprietaryParameterDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        ProprietaryParameterDynamicsService.updateProprietaryParameterDynamics(proprietaryParameterDynamics).then( res => {
            this.props.history.push('/proprietaryParameterDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/proprietaryParameterDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ProprietaryParameterDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateProprietaryParameterDynamics}>Save</button>
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

export default UpdateProprietaryParameterDynamicsComponent
