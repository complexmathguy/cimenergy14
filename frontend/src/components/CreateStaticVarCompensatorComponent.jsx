import React, { Component } from 'react'
import StaticVarCompensatorService from '../services/StaticVarCompensatorService';

class CreateStaticVarCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                sVCControlMode: ''
        }
        this.changeSVCControlModeHandler = this.changeSVCControlModeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            StaticVarCompensatorService.getStaticVarCompensatorById(this.state.id).then( (res) =>{
                let staticVarCompensator = res.data;
                this.setState({
                    sVCControlMode: staticVarCompensator.sVCControlMode
                });
            });
        }        
    }
    saveOrUpdateStaticVarCompensator = (e) => {
        e.preventDefault();
        let staticVarCompensator = {
                staticVarCompensatorId: this.state.id,
                sVCControlMode: this.state.sVCControlMode
            };
        console.log('staticVarCompensator => ' + JSON.stringify(staticVarCompensator));

        // step 5
        if(this.state.id === '_add'){
            staticVarCompensator.staticVarCompensatorId=''
            StaticVarCompensatorService.createStaticVarCompensator(staticVarCompensator).then(res =>{
                this.props.history.push('/staticVarCompensators');
            });
        }else{
            StaticVarCompensatorService.updateStaticVarCompensator(staticVarCompensator).then( res => {
                this.props.history.push('/staticVarCompensators');
            });
        }
    }
    
    changeSVCControlModeHandler= (event) => {
        this.setState({sVCControlMode: event.target.value});
    }

    cancel(){
        this.props.history.push('/staticVarCompensators');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add StaticVarCompensator</h3>
        }else{
            return <h3 className="text-center">Update StaticVarCompensator</h3>
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
                                            <label> SVCControlMode: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateStaticVarCompensator}>Save</button>
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

export default CreateStaticVarCompensatorComponent
