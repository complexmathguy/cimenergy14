import React, { Component } from 'react'
import LoadMotorService from '../services/LoadMotorService';

class CreateLoadMotorComponent extends Component {
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
            LoadMotorService.getLoadMotorById(this.state.id).then( (res) =>{
                let loadMotor = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLoadMotor = (e) => {
        e.preventDefault();
        let loadMotor = {
                loadMotorId: this.state.id,
            };
        console.log('loadMotor => ' + JSON.stringify(loadMotor));

        // step 5
        if(this.state.id === '_add'){
            loadMotor.loadMotorId=''
            LoadMotorService.createLoadMotor(loadMotor).then(res =>{
                this.props.history.push('/loadMotors');
            });
        }else{
            LoadMotorService.updateLoadMotor(loadMotor).then( res => {
                this.props.history.push('/loadMotors');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/loadMotors');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadMotor</h3>
        }else{
            return <h3 className="text-center">Update LoadMotor</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadMotor}>Save</button>
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

export default CreateLoadMotorComponent
