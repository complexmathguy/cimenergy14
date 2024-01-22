import React, { Component } from 'react'
import PssIEEE2BService from '../services/PssIEEE2BService';

class UpdatePssIEEE2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inputSignal1Type: '',
                inputSignal2Type: ''
        }
        this.updatePssIEEE2B = this.updatePssIEEE2B.bind(this);

        this.changeInputSignal1TypeHandler = this.changeInputSignal1TypeHandler.bind(this);
        this.changeInputSignal2TypeHandler = this.changeInputSignal2TypeHandler.bind(this);
    }

    componentDidMount(){
        PssIEEE2BService.getPssIEEE2BById(this.state.id).then( (res) =>{
            let pssIEEE2B = res.data;
            this.setState({
                inputSignal1Type: pssIEEE2B.inputSignal1Type,
                inputSignal2Type: pssIEEE2B.inputSignal2Type
            });
        });
    }

    updatePssIEEE2B = (e) => {
        e.preventDefault();
        let pssIEEE2B = {
            pssIEEE2BId: this.state.id,
            inputSignal1Type: this.state.inputSignal1Type,
            inputSignal2Type: this.state.inputSignal2Type
        };
        console.log('pssIEEE2B => ' + JSON.stringify(pssIEEE2B));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssIEEE2BService.updatePssIEEE2B(pssIEEE2B).then( res => {
            this.props.history.push('/pssIEEE2Bs');
        });
    }

    changeInputSignal1TypeHandler= (event) => {
        this.setState({inputSignal1Type: event.target.value});
    }
    changeInputSignal2TypeHandler= (event) => {
        this.setState({inputSignal2Type: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssIEEE2Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssIEEE2B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> InputSignal1Type: </label>
                                            #formFields( $attribute, 'update')
                                            <label> InputSignal2Type: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssIEEE2B}>Save</button>
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

export default UpdatePssIEEE2BComponent
