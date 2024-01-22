import React, { Component } from 'react'
import Pss1AService from '../services/Pss1AService';

class CreatePss1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                inputSignalType: ''
        }
        this.changeInputSignalTypeHandler = this.changeInputSignalTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            Pss1AService.getPss1AById(this.state.id).then( (res) =>{
                let pss1A = res.data;
                this.setState({
                    inputSignalType: pss1A.inputSignalType
                });
            });
        }        
    }
    saveOrUpdatePss1A = (e) => {
        e.preventDefault();
        let pss1A = {
                pss1AId: this.state.id,
                inputSignalType: this.state.inputSignalType
            };
        console.log('pss1A => ' + JSON.stringify(pss1A));

        // step 5
        if(this.state.id === '_add'){
            pss1A.pss1AId=''
            Pss1AService.createPss1A(pss1A).then(res =>{
                this.props.history.push('/pss1As');
            });
        }else{
            Pss1AService.updatePss1A(pss1A).then( res => {
                this.props.history.push('/pss1As');
            });
        }
    }
    
    changeInputSignalTypeHandler= (event) => {
        this.setState({inputSignalType: event.target.value});
    }

    cancel(){
        this.props.history.push('/pss1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Pss1A</h3>
        }else{
            return <h3 className="text-center">Update Pss1A</h3>
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
                                            <label> InputSignalType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePss1A}>Save</button>
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

export default CreatePss1AComponent
