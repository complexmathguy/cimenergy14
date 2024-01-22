import React, { Component } from 'react'
import StaticVarCompensatorService from '../services/StaticVarCompensatorService';

class UpdateStaticVarCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                sVCControlMode: ''
        }
        this.updateStaticVarCompensator = this.updateStaticVarCompensator.bind(this);

        this.changeSVCControlModeHandler = this.changeSVCControlModeHandler.bind(this);
    }

    componentDidMount(){
        StaticVarCompensatorService.getStaticVarCompensatorById(this.state.id).then( (res) =>{
            let staticVarCompensator = res.data;
            this.setState({
                sVCControlMode: staticVarCompensator.sVCControlMode
            });
        });
    }

    updateStaticVarCompensator = (e) => {
        e.preventDefault();
        let staticVarCompensator = {
            staticVarCompensatorId: this.state.id,
            sVCControlMode: this.state.sVCControlMode
        };
        console.log('staticVarCompensator => ' + JSON.stringify(staticVarCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        StaticVarCompensatorService.updateStaticVarCompensator(staticVarCompensator).then( res => {
            this.props.history.push('/staticVarCompensators');
        });
    }

    changeSVCControlModeHandler= (event) => {
        this.setState({sVCControlMode: event.target.value});
    }

    cancel(){
        this.props.history.push('/staticVarCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update StaticVarCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> SVCControlMode: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateStaticVarCompensator}>Save</button>
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

export default UpdateStaticVarCompensatorComponent
