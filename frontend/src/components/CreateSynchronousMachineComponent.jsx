import React, { Component } from 'react'
import SynchronousMachineService from '../services/SynchronousMachineService';

class CreateSynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                shortCircuitRotorType: '',
                type: ''
        }
        this.changeShortCircuitRotorTypeHandler = this.changeShortCircuitRotorTypeHandler.bind(this);
        this.changeTypeHandler = this.changeTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SynchronousMachineService.getSynchronousMachineById(this.state.id).then( (res) =>{
                let synchronousMachine = res.data;
                this.setState({
                    shortCircuitRotorType: synchronousMachine.shortCircuitRotorType,
                    type: synchronousMachine.type
                });
            });
        }        
    }
    saveOrUpdateSynchronousMachine = (e) => {
        e.preventDefault();
        let synchronousMachine = {
                synchronousMachineId: this.state.id,
                shortCircuitRotorType: this.state.shortCircuitRotorType,
                type: this.state.type
            };
        console.log('synchronousMachine => ' + JSON.stringify(synchronousMachine));

        // step 5
        if(this.state.id === '_add'){
            synchronousMachine.synchronousMachineId=''
            SynchronousMachineService.createSynchronousMachine(synchronousMachine).then(res =>{
                this.props.history.push('/synchronousMachines');
            });
        }else{
            SynchronousMachineService.updateSynchronousMachine(synchronousMachine).then( res => {
                this.props.history.push('/synchronousMachines');
            });
        }
    }
    
    changeShortCircuitRotorTypeHandler= (event) => {
        this.setState({shortCircuitRotorType: event.target.value});
    }
    changeTypeHandler= (event) => {
        this.setState({type: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachines');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachine</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachine</h3>
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
                                            <label> ShortCircuitRotorType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> Type: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachine}>Save</button>
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

export default CreateSynchronousMachineComponent
