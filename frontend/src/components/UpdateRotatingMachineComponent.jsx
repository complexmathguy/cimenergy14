import React, { Component } from 'react'
import RotatingMachineService from '../services/RotatingMachineService';

class UpdateRotatingMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateRotatingMachine = this.updateRotatingMachine.bind(this);

    }

    componentDidMount(){
        RotatingMachineService.getRotatingMachineById(this.state.id).then( (res) =>{
            let rotatingMachine = res.data;
            this.setState({
            });
        });
    }

    updateRotatingMachine = (e) => {
        e.preventDefault();
        let rotatingMachine = {
            rotatingMachineId: this.state.id,
        };
        console.log('rotatingMachine => ' + JSON.stringify(rotatingMachine));
        console.log('id => ' + JSON.stringify(this.state.id));
        RotatingMachineService.updateRotatingMachine(rotatingMachine).then( res => {
            this.props.history.push('/rotatingMachines');
        });
    }


    cancel(){
        this.props.history.push('/rotatingMachines');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RotatingMachine</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRotatingMachine}>Save</button>
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

export default UpdateRotatingMachineComponent
