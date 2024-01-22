import React, { Component } from 'react'
import ResistanceService from '../services/ResistanceService';

class UpdateResistanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateResistance = this.updateResistance.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        ResistanceService.getResistanceById(this.state.id).then( (res) =>{
            let resistance = res.data;
            this.setState({
                multiplier: resistance.multiplier,
                unit: resistance.unit
            });
        });
    }

    updateResistance = (e) => {
        e.preventDefault();
        let resistance = {
            resistanceId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('resistance => ' + JSON.stringify(resistance));
        console.log('id => ' + JSON.stringify(this.state.id));
        ResistanceService.updateResistance(resistance).then( res => {
            this.props.history.push('/resistances');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/resistances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Resistance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateResistance}>Save</button>
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

export default UpdateResistanceComponent
