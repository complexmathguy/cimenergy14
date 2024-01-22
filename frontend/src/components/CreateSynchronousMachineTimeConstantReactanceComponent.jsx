import React, { Component } from 'react'
import SynchronousMachineTimeConstantReactanceService from '../services/SynchronousMachineTimeConstantReactanceService';

class CreateSynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                modelType: '',
                rotorType: ''
        }
        this.changeModelTypeHandler = this.changeModelTypeHandler.bind(this);
        this.changeRotorTypeHandler = this.changeRotorTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SynchronousMachineTimeConstantReactanceService.getSynchronousMachineTimeConstantReactanceById(this.state.id).then( (res) =>{
                let synchronousMachineTimeConstantReactance = res.data;
                this.setState({
                    modelType: synchronousMachineTimeConstantReactance.modelType,
                    rotorType: synchronousMachineTimeConstantReactance.rotorType
                });
            });
        }        
    }
    saveOrUpdateSynchronousMachineTimeConstantReactance = (e) => {
        e.preventDefault();
        let synchronousMachineTimeConstantReactance = {
                synchronousMachineTimeConstantReactanceId: this.state.id,
                modelType: this.state.modelType,
                rotorType: this.state.rotorType
            };
        console.log('synchronousMachineTimeConstantReactance => ' + JSON.stringify(synchronousMachineTimeConstantReactance));

        // step 5
        if(this.state.id === '_add'){
            synchronousMachineTimeConstantReactance.synchronousMachineTimeConstantReactanceId=''
            SynchronousMachineTimeConstantReactanceService.createSynchronousMachineTimeConstantReactance(synchronousMachineTimeConstantReactance).then(res =>{
                this.props.history.push('/synchronousMachineTimeConstantReactances');
            });
        }else{
            SynchronousMachineTimeConstantReactanceService.updateSynchronousMachineTimeConstantReactance(synchronousMachineTimeConstantReactance).then( res => {
                this.props.history.push('/synchronousMachineTimeConstantReactances');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachineTimeConstantReactance</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachineTimeConstantReactance</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ModelType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> RotorType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachineTimeConstantReactance}>Save</button>
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

export default CreateSynchronousMachineTimeConstantReactanceComponent
