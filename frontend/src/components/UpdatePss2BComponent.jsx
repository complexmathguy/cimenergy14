import React, { Component } from 'react'
import Pss2BService from '../services/Pss2BService';

class UpdatePss2BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inputSignal1Type: '',
                inputSignal2Type: ''
        }
        this.updatePss2B = this.updatePss2B.bind(this);

        this.changeInputSignal1TypeHandler = this.changeInputSignal1TypeHandler.bind(this);
        this.changeInputSignal2TypeHandler = this.changeInputSignal2TypeHandler.bind(this);
    }

    componentDidMount(){
        Pss2BService.getPss2BById(this.state.id).then( (res) =>{
            let pss2B = res.data;
            this.setState({
                inputSignal1Type: pss2B.inputSignal1Type,
                inputSignal2Type: pss2B.inputSignal2Type
            });
        });
    }

    updatePss2B = (e) => {
        e.preventDefault();
        let pss2B = {
            pss2BId: this.state.id,
            inputSignal1Type: this.state.inputSignal1Type,
            inputSignal2Type: this.state.inputSignal2Type
        };
        console.log('pss2B => ' + JSON.stringify(pss2B));
        console.log('id => ' + JSON.stringify(this.state.id));
        Pss2BService.updatePss2B(pss2B).then( res => {
            this.props.history.push('/pss2Bs');
        });
    }

    changeInputSignal1TypeHandler= (event) => {
        this.setState({inputSignal1Type: event.target.value});
    }
    changeInputSignal2TypeHandler= (event) => {
        this.setState({inputSignal2Type: event.target.value});
    }

    cancel(){
        this.props.history.push('/pss2Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Pss2B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> InputSignal1Type: </label>
                                            #formFields( $attribute, 'update')
                                            <label> InputSignal2Type: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePss2B}>Save</button>
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

export default UpdatePss2BComponent
