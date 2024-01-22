import React, { Component } from 'react'
import PssWECCService from '../services/PssWECCService';

class UpdatePssWECCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inputSignal1Type: '',
                inputSignal2Type: ''
        }
        this.updatePssWECC = this.updatePssWECC.bind(this);

        this.changeInputSignal1TypeHandler = this.changeInputSignal1TypeHandler.bind(this);
        this.changeInputSignal2TypeHandler = this.changeInputSignal2TypeHandler.bind(this);
    }

    componentDidMount(){
        PssWECCService.getPssWECCById(this.state.id).then( (res) =>{
            let pssWECC = res.data;
            this.setState({
                inputSignal1Type: pssWECC.inputSignal1Type,
                inputSignal2Type: pssWECC.inputSignal2Type
            });
        });
    }

    updatePssWECC = (e) => {
        e.preventDefault();
        let pssWECC = {
            pssWECCId: this.state.id,
            inputSignal1Type: this.state.inputSignal1Type,
            inputSignal2Type: this.state.inputSignal2Type
        };
        console.log('pssWECC => ' + JSON.stringify(pssWECC));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssWECCService.updatePssWECC(pssWECC).then( res => {
            this.props.history.push('/pssWECCs');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssWECC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> InputSignal1Type: </label>
                                            #formFields( $attribute, 'update')
                                            <label> InputSignal2Type: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssWECC}>Save</button>
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

export default UpdatePssWECCComponent
