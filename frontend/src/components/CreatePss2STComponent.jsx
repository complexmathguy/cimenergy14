import React, { Component } from 'react'
import Pss2STService from '../services/Pss2STService';

class CreatePss2STComponent extends Component {
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
            Pss2STService.getPss2STById(this.state.id).then( (res) =>{
                let pss2ST = res.data;
                this.setState({
                    inputSignal1Type: pss2ST.inputSignal1Type,
                    inputSignal2Type: pss2ST.inputSignal2Type
                });
            });
        }        
    }
    saveOrUpdatePss2ST = (e) => {
        e.preventDefault();
        let pss2ST = {
                pss2STId: this.state.id,
                inputSignal1Type: this.state.inputSignal1Type,
                inputSignal2Type: this.state.inputSignal2Type
            };
        console.log('pss2ST => ' + JSON.stringify(pss2ST));

        // step 5
        if(this.state.id === '_add'){
            pss2ST.pss2STId=''
            Pss2STService.createPss2ST(pss2ST).then(res =>{
                this.props.history.push('/pss2STs');
            });
        }else{
            Pss2STService.updatePss2ST(pss2ST).then( res => {
                this.props.history.push('/pss2STs');
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
        this.props.history.push('/pss2STs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Pss2ST</h3>
        }else{
            return <h3 className="text-center">Update Pss2ST</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePss2ST}>Save</button>
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

export default CreatePss2STComponent
