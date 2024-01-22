import React, { Component } from 'react'
import MeasurementService from '../services/MeasurementService';

class CreateMeasurementComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                phases: '',
                unitMultiplier: '',
                unitSymbol: ''
        }
        this.changePhasesHandler = this.changePhasesHandler.bind(this);
        this.changeUnitMultiplierHandler = this.changeUnitMultiplierHandler.bind(this);
        this.changeUnitSymbolHandler = this.changeUnitSymbolHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            MeasurementService.getMeasurementById(this.state.id).then( (res) =>{
                let measurement = res.data;
                this.setState({
                    phases: measurement.phases,
                    unitMultiplier: measurement.unitMultiplier,
                    unitSymbol: measurement.unitSymbol
                });
            });
        }        
    }
    saveOrUpdateMeasurement = (e) => {
        e.preventDefault();
        let measurement = {
                measurementId: this.state.id,
                phases: this.state.phases,
                unitMultiplier: this.state.unitMultiplier,
                unitSymbol: this.state.unitSymbol
            };
        console.log('measurement => ' + JSON.stringify(measurement));

        // step 5
        if(this.state.id === '_add'){
            measurement.measurementId=''
            MeasurementService.createMeasurement(measurement).then(res =>{
                this.props.history.push('/measurements');
            });
        }else{
            MeasurementService.updateMeasurement(measurement).then( res => {
                this.props.history.push('/measurements');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Measurement</h3>
        }else{
            return <h3 className="text-center">Update Measurement</h3>
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
                                            <label> Phases: </label>
                                            #formFields( $attribute, 'create')
                                            <label> UnitMultiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> UnitSymbol: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMeasurement}>Save</button>
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

export default CreateMeasurementComponent
