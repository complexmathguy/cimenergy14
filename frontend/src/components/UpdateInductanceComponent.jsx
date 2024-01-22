import React, { Component } from 'react'
import InductanceService from '../services/InductanceService';

class UpdateInductanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateInductance = this.updateInductance.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        InductanceService.getInductanceById(this.state.id).then( (res) =>{
            let inductance = res.data;
            this.setState({
                multiplier: inductance.multiplier,
                unit: inductance.unit
            });
        });
    }

    updateInductance = (e) => {
        e.preventDefault();
        let inductance = {
            inductanceId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('inductance => ' + JSON.stringify(inductance));
        console.log('id => ' + JSON.stringify(this.state.id));
        InductanceService.updateInductance(inductance).then( res => {
            this.props.history.push('/inductances');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/inductances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Inductance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateInductance}>Save</button>
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

export default UpdateInductanceComponent
