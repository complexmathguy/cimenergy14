import React, { Component } from 'react'
import AsynchronousMachineService from '../services/AsynchronousMachineService';

class CreateAsynchronousMachineComponent extends Component {
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
            AsynchronousMachineService.getAsynchronousMachineById(this.state.id).then( (res) =>{
                let asynchronousMachine = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateAsynchronousMachine = (e) => {
        e.preventDefault();
        let asynchronousMachine = {
                asynchronousMachineId: this.state.id,
            };
        console.log('asynchronousMachine => ' + JSON.stringify(asynchronousMachine));

        // step 5
        if(this.state.id === '_add'){
            asynchronousMachine.asynchronousMachineId=''
            AsynchronousMachineService.createAsynchronousMachine(asynchronousMachine).then(res =>{
                this.props.history.push('/asynchronousMachines');
            });
        }else{
            AsynchronousMachineService.updateAsynchronousMachine(asynchronousMachine).then( res => {
                this.props.history.push('/asynchronousMachines');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/asynchronousMachines');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AsynchronousMachine</h3>
        }else{
            return <h3 className="text-center">Update AsynchronousMachine</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAsynchronousMachine}>Save</button>
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

export default CreateAsynchronousMachineComponent
