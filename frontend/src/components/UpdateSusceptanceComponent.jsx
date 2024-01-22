import React, { Component } from 'react'
import SusceptanceService from '../services/SusceptanceService';

class UpdateSusceptanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateSusceptance = this.updateSusceptance.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        SusceptanceService.getSusceptanceById(this.state.id).then( (res) =>{
            let susceptance = res.data;
            this.setState({
                multiplier: susceptance.multiplier,
                unit: susceptance.unit
            });
        });
    }

    updateSusceptance = (e) => {
        e.preventDefault();
        let susceptance = {
            susceptanceId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('susceptance => ' + JSON.stringify(susceptance));
        console.log('id => ' + JSON.stringify(this.state.id));
        SusceptanceService.updateSusceptance(susceptance).then( res => {
            this.props.history.push('/susceptances');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/susceptances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Susceptance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSusceptance}>Save</button>
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

export default UpdateSusceptanceComponent
