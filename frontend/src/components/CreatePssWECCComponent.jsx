import React, { Component } from 'react'
import PssWECCService from '../services/PssWECCService';

class CreatePssWECCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                inputSignal1Type: '',
                inputSignal2Type: ''
        }
        this.changeInputSignal1TypeHandler = this.changeInputSignal1TypeHandler.bind(this);
        this.changeInputSignal2TypeHandler = this.changeInputSignal2TypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PssWECCService.getPssWECCById(this.state.id).then( (res) =>{
                let pssWECC = res.data;
                this.setState({
                    inputSignal1Type: pssWECC.inputSignal1Type,
                    inputSignal2Type: pssWECC.inputSignal2Type
                });
            });
        }        
    }
    saveOrUpdatePssWECC = (e) => {
        e.preventDefault();
        let pssWECC = {
                pssWECCId: this.state.id,
                inputSignal1Type: this.state.inputSignal1Type,
                inputSignal2Type: this.state.inputSignal2Type
            };
        console.log('pssWECC => ' + JSON.stringify(pssWECC));

        // step 5
        if(this.state.id === '_add'){
            pssWECC.pssWECCId=''
            PssWECCService.createPssWECC(pssWECC).then(res =>{
                this.props.history.push('/pssWECCs');
            });
        }else{
            PssWECCService.updatePssWECC(pssWECC).then( res => {
                this.props.history.push('/pssWECCs');
            });
        }
    }
    
    changeInputSignal1TypeHandler= (event) => {
        this.setState({inputSignal1Type: event.target.value});
    }
    changeInputSignal2TypeHandler= (event) => {
        this.setState({inputSignal2Type: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssWECCs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssWECC</h3>
        }else{
            return <h3 className="text-center">Update PssWECC</h3>
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
                                            <label> InputSignal1Type: </label>
                                            #formFields( $attribute, 'create')
                                            <label> InputSignal2Type: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssWECC}>Save</button>
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

export default CreatePssWECCComponent
