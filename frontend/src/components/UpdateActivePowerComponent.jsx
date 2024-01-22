import React, { Component } from 'react'
import ActivePowerService from '../services/ActivePowerService';

class UpdateActivePowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateActivePower = this.updateActivePower.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        ActivePowerService.getActivePowerById(this.state.id).then( (res) =>{
            let activePower = res.data;
            this.setState({
                multiplier: activePower.multiplier,
                unit: activePower.unit
            });
        });
    }

    updateActivePower = (e) => {
        e.preventDefault();
        let activePower = {
            activePowerId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('activePower => ' + JSON.stringify(activePower));
        console.log('id => ' + JSON.stringify(this.state.id));
        ActivePowerService.updateActivePower(activePower).then( res => {
            this.props.history.push('/activePowers');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/activePowers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ActivePower</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateActivePower}>Save</button>
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

export default UpdateActivePowerComponent
