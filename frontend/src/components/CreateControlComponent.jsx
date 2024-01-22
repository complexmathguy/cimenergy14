import React, { Component } from 'react'
import ControlService from '../services/ControlService';

class CreateControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                unitMultiplier: '',
                unitSymbol: ''
        }
        this.changeUnitMultiplierHandler = this.changeUnitMultiplierHandler.bind(this);
        this.changeUnitSymbolHandler = this.changeUnitSymbolHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ControlService.getControlById(this.state.id).then( (res) =>{
                let control = res.data;
                this.setState({
                    unitMultiplier: control.unitMultiplier,
                    unitSymbol: control.unitSymbol
                });
            });
        }        
    }
    saveOrUpdateControl = (e) => {
        e.preventDefault();
        let control = {
                controlId: this.state.id,
                unitMultiplier: this.state.unitMultiplier,
                unitSymbol: this.state.unitSymbol
            };
        console.log('control => ' + JSON.stringify(control));

        // step 5
        if(this.state.id === '_add'){
            control.controlId=''
            ControlService.createControl(control).then(res =>{
                this.props.history.push('/controls');
            });
        }else{
            ControlService.updateControl(control).then( res => {
                this.props.history.push('/controls');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Control</h3>
        }else{
            return <h3 className="text-center">Update Control</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> UnitMultiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> UnitSymbol: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateControl}>Save</button>
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

export default CreateControlComponent
