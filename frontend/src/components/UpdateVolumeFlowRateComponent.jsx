import React, { Component } from 'react'
import VolumeFlowRateService from '../services/VolumeFlowRateService';

class UpdateVolumeFlowRateComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: ''
        }
        this.updateVolumeFlowRate = this.updateVolumeFlowRate.bind(this);

        this.changeDenominatorMultiplierHandler = this.changeDenominatorMultiplierHandler.bind(this);
        this.changeDenominatorUnitHandler = this.changeDenominatorUnitHandler.bind(this);
        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        VolumeFlowRateService.getVolumeFlowRateById(this.state.id).then( (res) =>{
            let volumeFlowRate = res.data;
            this.setState({
                denominatorMultiplier: volumeFlowRate.denominatorMultiplier,
                denominatorUnit: volumeFlowRate.denominatorUnit,
                multiplier: volumeFlowRate.multiplier,
                unit: volumeFlowRate.unit
            });
        });
    }

    updateVolumeFlowRate = (e) => {
        e.preventDefault();
        let volumeFlowRate = {
            volumeFlowRateId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('volumeFlowRate => ' + JSON.stringify(volumeFlowRate));
        console.log('id => ' + JSON.stringify(this.state.id));
        VolumeFlowRateService.updateVolumeFlowRate(volumeFlowRate).then( res => {
            this.props.history.push('/volumeFlowRates');
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
        this.props.history.push('/volumeFlowRates');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VolumeFlowRate</h3>
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
                                        <button className="btn btn-success" onClick={this.updateVolumeFlowRate}>Save</button>
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

export default UpdateVolumeFlowRateComponent
