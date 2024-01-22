import React, { Component } from 'react'
import AsynchronousMachineTimeConstantReactanceService from '../services/AsynchronousMachineTimeConstantReactanceService';

class CreateAsynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            AsynchronousMachineTimeConstantReactanceService.getAsynchronousMachineTimeConstantReactanceById(this.state.id).then( (res) =>{
                let asynchronousMachineTimeConstantReactance = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAsynchronousMachineTimeConstantReactance = (e) => {
        e.preventDefault();
        let asynchronousMachineTimeConstantReactance = {
                asynchronousMachineTimeConstantReactanceId: this.state.id,
            };
        console.log('asynchronousMachineTimeConstantReactance => ' + JSON.stringify(asynchronousMachineTimeConstantReactance));

        // step 5
        if(this.state.id === '_add'){
            asynchronousMachineTimeConstantReactance.asynchronousMachineTimeConstantReactanceId=''
            AsynchronousMachineTimeConstantReactanceService.createAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance).then(res =>{
                this.props.history.push('/asynchronousMachineTimeConstantReactances');
            });
        }else{
            AsynchronousMachineTimeConstantReactanceService.updateAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance).then( res => {
                this.props.history.push('/asynchronousMachineTimeConstantReactances');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/asynchronousMachineTimeConstantReactances');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AsynchronousMachineTimeConstantReactance</h3>
        }else{
            return <h3 className="text-center">Update AsynchronousMachineTimeConstantReactance</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAsynchronousMachineTimeConstantReactance}>Save</button>
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

export default CreateAsynchronousMachineTimeConstantReactanceComponent
