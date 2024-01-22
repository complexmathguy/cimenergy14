import React, { Component } from 'react'
import FrequencyService from '../services/FrequencyService';

class UpdateFrequencyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateFrequency = this.updateFrequency.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        FrequencyService.getFrequencyById(this.state.id).then( (res) =>{
            let frequency = res.data;
            this.setState({
                multiplier: frequency.multiplier,
                unit: frequency.unit
            });
        });
    }

    updateFrequency = (e) => {
        e.preventDefault();
        let frequency = {
            frequencyId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('frequency => ' + JSON.stringify(frequency));
        console.log('id => ' + JSON.stringify(this.state.id));
        FrequencyService.updateFrequency(frequency).then( res => {
            this.props.history.push('/frequencys');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/frequencys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Frequency</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateFrequency}>Save</button>
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

export default UpdateFrequencyComponent
