import React, { Component } from 'react'
import Pss2STService from '../services/Pss2STService';

class UpdatePss2STComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inputSignal1Type: '',
                inputSignal2Type: ''
        }
        this.updatePss2ST = this.updatePss2ST.bind(this);

        this.changeInputSignal1TypeHandler = this.changeInputSignal1TypeHandler.bind(this);
        this.changeInputSignal2TypeHandler = this.changeInputSignal2TypeHandler.bind(this);
    }

    componentDidMount(){
        Pss2STService.getPss2STById(this.state.id).then( (res) =>{
            let pss2ST = res.data;
            this.setState({
                inputSignal1Type: pss2ST.inputSignal1Type,
                inputSignal2Type: pss2ST.inputSignal2Type
            });
        });
    }

    updatePss2ST = (e) => {
        e.preventDefault();
        let pss2ST = {
            pss2STId: this.state.id,
            inputSignal1Type: this.state.inputSignal1Type,
            inputSignal2Type: this.state.inputSignal2Type
        };
        console.log('pss2ST => ' + JSON.stringify(pss2ST));
        console.log('id => ' + JSON.stringify(this.state.id));
        Pss2STService.updatePss2ST(pss2ST).then( res => {
            this.props.history.push('/pss2STs');
        });
    }

    changeInputSignal1TypeHandler= (event) => {
        this.setState({inputSignal1Type: event.target.value});
    }
    changeInputSignal2TypeHandler= (event) => {
        this.setState({inputSignal2Type: event.target.value});
    }

    cancel(){
        this.props.history.push('/pss2STs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Pss2ST</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> InputSignal1Type: </label>
                                            #formFields( $attribute, 'update')
                                            <label> InputSignal2Type: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePss2ST}>Save</button>
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

export default UpdatePss2STComponent
