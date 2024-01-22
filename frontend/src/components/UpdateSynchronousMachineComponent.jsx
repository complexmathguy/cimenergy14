import React, { Component } from 'react'
import SynchronousMachineService from '../services/SynchronousMachineService';

class UpdateSynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                shortCircuitRotorType: '',
                type: ''
        }
        this.updateSynchronousMachine = this.updateSynchronousMachine.bind(this);

        this.changeShortCircuitRotorTypeHandler = this.changeShortCircuitRotorTypeHandler.bind(this);
        this.changeTypeHandler = this.changeTypeHandler.bind(this);
    }

    componentDidMount(){
        SynchronousMachineService.getSynchronousMachineById(this.state.id).then( (res) =>{
            let synchronousMachine = res.data;
            this.setState({
                shortCircuitRotorType: synchronousMachine.shortCircuitRotorType,
                type: synchronousMachine.type
            });
        });
    }

    updateSynchronousMachine = (e) => {
        e.preventDefault();
        let synchronousMachine = {
            synchronousMachineId: this.state.id,
            shortCircuitRotorType: this.state.shortCircuitRotorType,
            type: this.state.type
        };
        console.log('synchronousMachine => ' + JSON.stringify(synchronousMachine));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineService.updateSynchronousMachine(synchronousMachine).then( res => {
            this.props.history.push('/synchronousMachines');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachine</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ShortCircuitRotorType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Type: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachine}>Save</button>
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

export default UpdateSynchronousMachineComponent
