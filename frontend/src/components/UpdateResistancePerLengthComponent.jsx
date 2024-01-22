import React, { Component } from 'react'
import ResistancePerLengthService from '../services/ResistancePerLengthService';

class UpdateResistancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: ''
        }
        this.updateResistancePerLength = this.updateResistancePerLength.bind(this);

        this.changeDenominatorMultiplierHandler = this.changeDenominatorMultiplierHandler.bind(this);
        this.changeDenominatorUnitHandler = this.changeDenominatorUnitHandler.bind(this);
        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        ResistancePerLengthService.getResistancePerLengthById(this.state.id).then( (res) =>{
            let resistancePerLength = res.data;
            this.setState({
                denominatorMultiplier: resistancePerLength.denominatorMultiplier,
                denominatorUnit: resistancePerLength.denominatorUnit,
                multiplier: resistancePerLength.multiplier,
                unit: resistancePerLength.unit
            });
        });
    }

    updateResistancePerLength = (e) => {
        e.preventDefault();
        let resistancePerLength = {
            resistancePerLengthId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('resistancePerLength => ' + JSON.stringify(resistancePerLength));
        console.log('id => ' + JSON.stringify(this.state.id));
        ResistancePerLengthService.updateResistancePerLength(resistancePerLength).then( res => {
            this.props.history.push('/resistancePerLengths');
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
        this.props.history.push('/resistancePerLengths');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ResistancePerLength</h3>
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
                                        <button className="btn btn-success" onClick={this.updateResistancePerLength}>Save</button>
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

export default UpdateResistancePerLengthComponent
