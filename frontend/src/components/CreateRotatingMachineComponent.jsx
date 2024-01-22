import React, { Component } from 'react'
import RotatingMachineService from '../services/RotatingMachineService';

class CreateRotatingMachineComponent extends Component {
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
            RotatingMachineService.getRotatingMachineById(this.state.id).then( (res) =>{
                let rotatingMachine = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateRotatingMachine = (e) => {
        e.preventDefault();
        let rotatingMachine = {
                rotatingMachineId: this.state.id,
            };
        console.log('rotatingMachine => ' + JSON.stringify(rotatingMachine));

        // step 5
        if(this.state.id === '_add'){
            rotatingMachine.rotatingMachineId=''
            RotatingMachineService.createRotatingMachine(rotatingMachine).then(res =>{
                this.props.history.push('/rotatingMachines');
            });
        }else{
            RotatingMachineService.updateRotatingMachine(rotatingMachine).then( res => {
                this.props.history.push('/rotatingMachines');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/rotatingMachines');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RotatingMachine</h3>
        }else{
            return <h3 className="text-center">Update RotatingMachine</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRotatingMachine}>Save</button>
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

export default CreateRotatingMachineComponent
