import React, { Component } from 'react'
import ControlService from '../services/ControlService';

class UpdateControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                unitMultiplier: '',
                unitSymbol: ''
        }
        this.updateControl = this.updateControl.bind(this);

        this.changeUnitMultiplierHandler = this.changeUnitMultiplierHandler.bind(this);
        this.changeUnitSymbolHandler = this.changeUnitSymbolHandler.bind(this);
    }

    componentDidMount(){
        ControlService.getControlById(this.state.id).then( (res) =>{
            let control = res.data;
            this.setState({
                unitMultiplier: control.unitMultiplier,
                unitSymbol: control.unitSymbol
            });
        });
    }

    updateControl = (e) => {
        e.preventDefault();
        let control = {
            controlId: this.state.id,
            unitMultiplier: this.state.unitMultiplier,
            unitSymbol: this.state.unitSymbol
        };
        console.log('control => ' + JSON.stringify(control));
        console.log('id => ' + JSON.stringify(this.state.id));
        ControlService.updateControl(control).then( res => {
            this.props.history.push('/controls');
        });
    }

    changeUnitMultiplierHandler= (event) => {
        this.setState({unitMultiplier: event.target.value});
    }
    changeUnitSymbolHandler= (event) => {
        this.setState({unitSymbol: event.target.value});
    }

    cancel(){
        this.props.history.push('/controls');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Control</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> UnitMultiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> UnitSymbol: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateControl}>Save</button>
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

export default UpdateControlComponent
