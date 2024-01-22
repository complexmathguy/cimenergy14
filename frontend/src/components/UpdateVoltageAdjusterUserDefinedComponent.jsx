import React, { Component } from 'react'
import VoltageAdjusterUserDefinedService from '../services/VoltageAdjusterUserDefinedService';

class UpdateVoltageAdjusterUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateVoltageAdjusterUserDefined = this.updateVoltageAdjusterUserDefined.bind(this);

    }

    componentDidMount(){
        VoltageAdjusterUserDefinedService.getVoltageAdjusterUserDefinedById(this.state.id).then( (res) =>{
            let voltageAdjusterUserDefined = res.data;
            this.setState({
            });
        });
    }

    updateVoltageAdjusterUserDefined = (e) => {
        e.preventDefault();
        let voltageAdjusterUserDefined = {
            voltageAdjusterUserDefinedId: this.state.id,
        };
        console.log('voltageAdjusterUserDefined => ' + JSON.stringify(voltageAdjusterUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltageAdjusterUserDefinedService.updateVoltageAdjusterUserDefined(voltageAdjusterUserDefined).then( res => {
            this.props.history.push('/voltageAdjusterUserDefineds');
        });
    }


    cancel(){
        this.props.history.push('/voltageAdjusterUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VoltageAdjusterUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVoltageAdjusterUserDefined}>Save</button>
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

export default UpdateVoltageAdjusterUserDefinedComponent
