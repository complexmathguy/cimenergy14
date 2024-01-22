import React, { Component } from 'react'
import AsynchronousMachineTimeConstantReactanceService from '../services/AsynchronousMachineTimeConstantReactanceService';

class UpdateAsynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAsynchronousMachineTimeConstantReactance = this.updateAsynchronousMachineTimeConstantReactance.bind(this);

    }

    componentDidMount(){
        AsynchronousMachineTimeConstantReactanceService.getAsynchronousMachineTimeConstantReactanceById(this.state.id).then( (res) =>{
            let asynchronousMachineTimeConstantReactance = res.data;
            this.setState({
            });
        });
    }

    updateAsynchronousMachineTimeConstantReactance = (e) => {
        e.preventDefault();
        let asynchronousMachineTimeConstantReactance = {
            asynchronousMachineTimeConstantReactanceId: this.state.id,
        };
        console.log('asynchronousMachineTimeConstantReactance => ' + JSON.stringify(asynchronousMachineTimeConstantReactance));
        console.log('id => ' + JSON.stringify(this.state.id));
        AsynchronousMachineTimeConstantReactanceService.updateAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance).then( res => {
            this.props.history.push('/asynchronousMachineTimeConstantReactances');
        });
    }


    cancel(){
        this.props.history.push('/asynchronousMachineTimeConstantReactances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AsynchronousMachineTimeConstantReactance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAsynchronousMachineTimeConstantReactance}>Save</button>
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

export default UpdateAsynchronousMachineTimeConstantReactanceComponent
