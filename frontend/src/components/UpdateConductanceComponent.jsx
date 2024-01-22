import React, { Component } from 'react'
import ConductanceService from '../services/ConductanceService';

class UpdateConductanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateConductance = this.updateConductance.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        ConductanceService.getConductanceById(this.state.id).then( (res) =>{
            let conductance = res.data;
            this.setState({
                multiplier: conductance.multiplier,
                unit: conductance.unit
            });
        });
    }

    updateConductance = (e) => {
        e.preventDefault();
        let conductance = {
            conductanceId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('conductance => ' + JSON.stringify(conductance));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConductanceService.updateConductance(conductance).then( res => {
            this.props.history.push('/conductances');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/conductances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Conductance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConductance}>Save</button>
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

export default UpdateConductanceComponent
