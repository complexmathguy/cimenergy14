import React, { Component } from 'react'
import SecondsService from '../services/SecondsService';

class UpdateSecondsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateSeconds = this.updateSeconds.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        SecondsService.getSecondsById(this.state.id).then( (res) =>{
            let seconds = res.data;
            this.setState({
                multiplier: seconds.multiplier,
                unit: seconds.unit
            });
        });
    }

    updateSeconds = (e) => {
        e.preventDefault();
        let seconds = {
            secondsId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('seconds => ' + JSON.stringify(seconds));
        console.log('id => ' + JSON.stringify(this.state.id));
        SecondsService.updateSeconds(seconds).then( res => {
            this.props.history.push('/secondss');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/secondss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Seconds</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSeconds}>Save</button>
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

export default UpdateSecondsComponent
