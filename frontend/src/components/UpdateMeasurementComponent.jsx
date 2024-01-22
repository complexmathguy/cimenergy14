import React, { Component } from 'react'
import MeasurementService from '../services/MeasurementService';

class UpdateMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                phases: '',
                unitMultiplier: '',
                unitSymbol: ''
        }
        this.updateMeasurement = this.updateMeasurement.bind(this);

        this.changePhasesHandler = this.changePhasesHandler.bind(this);
        this.changeUnitMultiplierHandler = this.changeUnitMultiplierHandler.bind(this);
        this.changeUnitSymbolHandler = this.changeUnitSymbolHandler.bind(this);
    }

    componentDidMount(){
        MeasurementService.getMeasurementById(this.state.id).then( (res) =>{
            let measurement = res.data;
            this.setState({
                phases: measurement.phases,
                unitMultiplier: measurement.unitMultiplier,
                unitSymbol: measurement.unitSymbol
            });
        });
    }

    updateMeasurement = (e) => {
        e.preventDefault();
        let measurement = {
            measurementId: this.state.id,
            phases: this.state.phases,
            unitMultiplier: this.state.unitMultiplier,
            unitSymbol: this.state.unitSymbol
        };
        console.log('measurement => ' + JSON.stringify(measurement));
        console.log('id => ' + JSON.stringify(this.state.id));
        MeasurementService.updateMeasurement(measurement).then( res => {
            this.props.history.push('/measurements');
        });
    }

    changePhasesHandler= (event) => {
        this.setState({phases: event.target.value});
    }
    changeUnitMultiplierHandler= (event) => {
        this.setState({unitMultiplier: event.target.value});
    }
    changeUnitSymbolHandler= (event) => {
        this.setState({unitSymbol: event.target.value});
    }

    cancel(){
        this.props.history.push('/measurements');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Measurement</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Phases: </label>
                                            #formFields( $attribute, 'update')
                                            <label> UnitMultiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> UnitSymbol: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMeasurement}>Save</button>
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

export default UpdateMeasurementComponent
