import React, { Component } from 'react'
import PssIEEE3BService from '../services/PssIEEE3BService';

class CreatePssIEEE3BComponent extends Component {
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
            PssIEEE3BService.getPssIEEE3BById(this.state.id).then( (res) =>{
                let pssIEEE3B = res.data;
                this.setState({
                    inputSignal1Type: pssIEEE3B.inputSignal1Type,
                    inputSignal2Type: pssIEEE3B.inputSignal2Type
                });
            });
        }        
    }
    saveOrUpdatePssIEEE3B = (e) => {
        e.preventDefault();
        let pssIEEE3B = {
                pssIEEE3BId: this.state.id,
                inputSignal1Type: this.state.inputSignal1Type,
                inputSignal2Type: this.state.inputSignal2Type
            };
        console.log('pssIEEE3B => ' + JSON.stringify(pssIEEE3B));

        // step 5
        if(this.state.id === '_add'){
            pssIEEE3B.pssIEEE3BId=''
            PssIEEE3BService.createPssIEEE3B(pssIEEE3B).then(res =>{
                this.props.history.push('/pssIEEE3Bs');
            });
        }else{
            PssIEEE3BService.updatePssIEEE3B(pssIEEE3B).then( res => {
                this.props.history.push('/pssIEEE3Bs');
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
        this.props.history.push('/pssIEEE3Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssIEEE3B</h3>
        }else{
            return <h3 className="text-center">Update PssIEEE3B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssIEEE3B}>Save</button>
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

export default CreatePssIEEE3BComponent
