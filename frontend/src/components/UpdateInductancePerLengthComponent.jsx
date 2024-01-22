import React, { Component } from 'react'
import InductancePerLengthService from '../services/InductancePerLengthService';

class UpdateInductancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: ''
        }
        this.updateInductancePerLength = this.updateInductancePerLength.bind(this);

        this.changeDenominatorMultiplierHandler = this.changeDenominatorMultiplierHandler.bind(this);
        this.changeDenominatorUnitHandler = this.changeDenominatorUnitHandler.bind(this);
        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        InductancePerLengthService.getInductancePerLengthById(this.state.id).then( (res) =>{
            let inductancePerLength = res.data;
            this.setState({
                denominatorMultiplier: inductancePerLength.denominatorMultiplier,
                denominatorUnit: inductancePerLength.denominatorUnit,
                multiplier: inductancePerLength.multiplier,
                unit: inductancePerLength.unit
            });
        });
    }

    updateInductancePerLength = (e) => {
        e.preventDefault();
        let inductancePerLength = {
            inductancePerLengthId: this.state.id,
            denominatorMultiplier: this.state.denominatorMultiplier,
            denominatorUnit: this.state.denominatorUnit,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('inductancePerLength => ' + JSON.stringify(inductancePerLength));
        console.log('id => ' + JSON.stringify(this.state.id));
        InductancePerLengthService.updateInductancePerLength(inductancePerLength).then( res => {
            this.props.history.push('/inductancePerLengths');
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
        this.props.history.push('/inductancePerLengths');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update InductancePerLength</h3>
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
                                        <button className="btn btn-success" onClick={this.updateInductancePerLength}>Save</button>
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

export default UpdateInductancePerLengthComponent
