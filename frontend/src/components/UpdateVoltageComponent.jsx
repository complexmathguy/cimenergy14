import React, { Component } from 'react'
import VoltageService from '../services/VoltageService';

class UpdateVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateVoltage = this.updateVoltage.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        VoltageService.getVoltageById(this.state.id).then( (res) =>{
            let voltage = res.data;
            this.setState({
                multiplier: voltage.multiplier,
                unit: voltage.unit
            });
        });
    }

    updateVoltage = (e) => {
        e.preventDefault();
        let voltage = {
            voltageId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('voltage => ' + JSON.stringify(voltage));
        console.log('id => ' + JSON.stringify(this.state.id));
        VoltageService.updateVoltage(voltage).then( res => {
            this.props.history.push('/voltages');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/voltages');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Voltage</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVoltage}>Save</button>
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

export default UpdateVoltageComponent
