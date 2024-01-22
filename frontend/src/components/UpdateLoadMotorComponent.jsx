import React, { Component } from 'react'
import LoadMotorService from '../services/LoadMotorService';

class UpdateLoadMotorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLoadMotor = this.updateLoadMotor.bind(this);

    }

    componentDidMount(){
        LoadMotorService.getLoadMotorById(this.state.id).then( (res) =>{
            let loadMotor = res.data;
            this.setState({
            });
        });
    }

    updateLoadMotor = (e) => {
        e.preventDefault();
        let loadMotor = {
            loadMotorId: this.state.id,
        };
        console.log('loadMotor => ' + JSON.stringify(loadMotor));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadMotorService.updateLoadMotor(loadMotor).then( res => {
            this.props.history.push('/loadMotors');
        });
    }


    cancel(){
        this.props.history.push('/loadMotors');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadMotor</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadMotor}>Save</button>
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

export default UpdateLoadMotorComponent
