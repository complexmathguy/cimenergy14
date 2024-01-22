import React, { Component } from 'react'
import VoltagePerReactivePowerService from '../services/VoltagePerReactivePowerService';

class UpdateVoltagePerReactivePowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: ''
        }
        this.updateVoltagePerReactivePower = this.updateVoltagePerReactivePower.bind(this);

        this.changeDenominatorMultiplierHandler = this.changeDenominatorMultiplierHandler.bind(this);
        this.changeDenominatorUnitHandler = this.changeDenominatorUnitHandler.bind(this);
        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        VoltagePerReactivePowerService.getVoltagePerReactivePowerById(this.state.id).then( (res) =>{
            let voltagePerReactivePower = res.data;
            this.setState({
                denominatorMultiplier: voltagePerReactivePower.denominatorMultiplier,
                denominatorUnit: voltagePerReactivePower.denominatorUnit,
                multiplier: voltagePerReactivePower.multiplier,
                unit: voltagePerReactivePower.unit
            });
        });
    }

    updateVoltagePerReactivePower = (e) => {
        e.preventDefault();
        let voltagePerReactivePower = {
            voltagePerReactivePowerId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('voltagePerReactivePower => ' + JSON.stringify(voltagePerReactivePower));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltagePerReactivePowerService.updateVoltagePerReactivePower(voltagePerReactivePower).then( res => {
            this.props.history.push('/voltagePerReactivePowers');
        });
    }

    changeDenominatorMultiplierHandler= (event) => {
        this.setState({denominatorMultiplier: event.target.value});
    }
    changeDenominatorUnitHandler= (event) => {
        this.setState({denominatorUnit: event.target.value});
    }
    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/voltagePerReactivePowers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VoltagePerReactivePower</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> DenominatorMultiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> DenominatorUnit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVoltagePerReactivePower}>Save</button>
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

export default UpdateVoltagePerReactivePowerComponent
