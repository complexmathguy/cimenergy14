import React, { Component } from 'react'
import LengthService from '../services/LengthService';

class UpdateLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateLength = this.updateLength.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        LengthService.getLengthById(this.state.id).then( (res) =>{
            let length = res.data;
            this.setState({
                multiplier: length.multiplier,
                unit: length.unit
            });
        });
    }

    updateLength = (e) => {
        e.preventDefault();
        let length = {
            lengthId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('length => ' + JSON.stringify(length));
        console.log('id => ' + JSON.stringify(this.state.id));
        LengthService.updateLength(length).then( res => {
            this.props.history.push('/lengths');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/lengths');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Length</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLength}>Save</button>
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

export default UpdateLengthComponent
