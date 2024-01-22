import React, { Component } from 'react'
import ResistancePerLengthService from '../services/ResistancePerLengthService';

class CreateResistancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                denominatorMultiplier: '',
                denominatorUnit: '',
                multiplier: '',
                unit: ''
        }
        this.changeDenominatorMultiplierHandler = this.changeDenominatorMultiplierHandler.bind(this);
        this.changeDenominatorUnitHandler = this.changeDenominatorUnitHandler.bind(this);
        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ResistancePerLengthService.getResistancePerLengthById(this.state.id).then( (res) =>{
                let resistancePerLength = res.data;
                this.setState({
                    denominatorMultiplier: resistancePerLength.denominatorMultiplier,
                    denominatorUnit: resistancePerLength.denominatorUnit,
                    multiplier: resistancePerLength.multiplier,
                    unit: resistancePerLength.unit
                });
            });
        }        
    }
    saveOrUpdateResistancePerLength = (e) => {
        e.preventDefault();
        let resistancePerLength = {
                resistancePerLengthId: this.state.id,
                denominatorMultiplier: this.state.denominatorMultiplier,
                denominatorUnit: this.state.denominatorUnit,
                multiplier: this.state.multiplier,
                unit: this.state.unit
            };
        console.log('resistancePerLength => ' + JSON.stringify(resistancePerLength));

        // step 5
        if(this.state.id === '_add'){
            resistancePerLength.resistancePerLengthId=''
            ResistancePerLengthService.createResistancePerLength(resistancePerLength).then(res =>{
                this.props.history.push('/resistancePerLengths');
            });
        }else{
            ResistancePerLengthService.updateResistancePerLength(resistancePerLength).then( res => {
                this.props.history.push('/resistancePerLengths');
            });
        }
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
        this.props.history.push('/resistancePerLengths');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ResistancePerLength</h3>
        }else{
            return <h3 className="text-center">Update ResistancePerLength</h3>
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
                                            <label> DenominatorMultiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> DenominatorUnit: </label>
                                            #formFields( $attribute, 'create')
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'create')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateResistancePerLength}>Save</button>
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

export default CreateResistancePerLengthComponent
