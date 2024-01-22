import React, { Component } from 'react'
import SynchronousMachineTimeConstantReactanceService from '../services/SynchronousMachineTimeConstantReactanceService';

class UpdateSynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                modelType: '',
                rotorType: ''
        }
        this.updateSynchronousMachineTimeConstantReactance = this.updateSynchronousMachineTimeConstantReactance.bind(this);

        this.changeModelTypeHandler = this.changeModelTypeHandler.bind(this);
        this.changeRotorTypeHandler = this.changeRotorTypeHandler.bind(this);
    }

    componentDidMount(){
        SynchronousMachineTimeConstantReactanceService.getSynchronousMachineTimeConstantReactanceById(this.state.id).then( (res) =>{
            let synchronousMachineTimeConstantReactance = res.data;
            this.setState({
                modelType: synchronousMachineTimeConstantReactance.modelType,
                rotorType: synchronousMachineTimeConstantReactance.rotorType
            });
        });
    }

    updateSynchronousMachineTimeConstantReactance = (e) => {
        e.preventDefault();
        let synchronousMachineTimeConstantReactance = {
            synchronousMachineTimeConstantReactanceId: this.state.id,
            modelType: this.state.modelType,
            rotorType: this.state.rotorType
        };
        console.log('synchronousMachineTimeConstantReactance => ' + JSON.stringify(synchronousMachineTimeConstantReactance));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineTimeConstantReactanceService.updateSynchronousMachineTimeConstantReactance(synchronousMachineTimeConstantReactance).then( res => {
            this.props.history.push('/synchronousMachineTimeConstantReactances');
        });
    }

    changeModelTypeHandler= (event) => {
        this.setState({modelType: event.target.value});
    }
    changeRotorTypeHandler= (event) => {
        this.setState({rotorType: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachineTimeConstantReactances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineTimeConstantReactance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ModelType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> RotorType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineTimeConstantReactance}>Save</button>
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

export default UpdateSynchronousMachineTimeConstantReactanceComponent
