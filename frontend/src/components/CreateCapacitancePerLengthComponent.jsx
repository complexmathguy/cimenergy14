import React, { Component } from 'react'
import CapacitancePerLengthService from '../services/CapacitancePerLengthService';

class CreateCapacitancePerLengthComponent extends Component {
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
            CapacitancePerLengthService.getCapacitancePerLengthById(this.state.id).then( (res) =>{
                let capacitancePerLength = res.data;
                this.setState({
                    denominatorMultiplier: capacitancePerLength.denominatorMultiplier,
                    denominatorUnit: capacitancePerLength.denominatorUnit,
                    multiplier: capacitancePerLength.multiplier,
                    unit: capacitancePerLength.unit
                });
            });
        }        
    }
    saveOrUpdateCapacitancePerLength = (e) => {
        e.preventDefault();
        let capacitancePerLength = {
                capacitancePerLengthId: this.state.id,
                denominatorMultiplier: this.state.denominatorMultiplier,
                denominatorUnit: this.state.denominatorUnit,
                multiplier: this.state.multiplier,
                unit: this.state.unit
            };
        console.log('capacitancePerLength => ' + JSON.stringify(capacitancePerLength));

        // step 5
        if(this.state.id === '_add'){
            capacitancePerLength.capacitancePerLengthId=''
            CapacitancePerLengthService.createCapacitancePerLength(capacitancePerLength).then(res =>{
                this.props.history.push('/capacitancePerLengths');
            });
        }else{
            CapacitancePerLengthService.updateCapacitancePerLength(capacitancePerLength).then( res => {
                this.props.history.push('/capacitancePerLengths');
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
        this.props.history.push('/capacitancePerLengths');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add CapacitancePerLength</h3>
        }else{
            return <h3 className="text-center">Update CapacitancePerLength</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCapacitancePerLength}>Save</button>
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

export default CreateCapacitancePerLengthComponent
