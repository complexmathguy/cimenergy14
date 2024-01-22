import React, { Component } from 'react'
import AsynchronousMachineService from '../services/AsynchronousMachineService';

class UpdateAsynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAsynchronousMachine = this.updateAsynchronousMachine.bind(this);

    }

    componentDidMount(){
        AsynchronousMachineService.getAsynchronousMachineById(this.state.id).then( (res) =>{
            let asynchronousMachine = res.data;
            this.setState({
            });
        });
    }

    updateAsynchronousMachine = (e) => {
        e.preventDefault();
        let asynchronousMachine = {
            asynchronousMachineId: this.state.id,
        };
        console.log('asynchronousMachine => ' + JSON.stringify(asynchronousMachine));
        console.log('id => ' + JSON.stringify(this.state.id));
        AsynchronousMachineService.updateAsynchronousMachine(asynchronousMachine).then( res => {
            this.props.history.push('/asynchronousMachines');
        });
    }


    cancel(){
        this.props.history.push('/asynchronousMachines');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AsynchronousMachine</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAsynchronousMachine}>Save</button>
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

export default UpdateAsynchronousMachineComponent
