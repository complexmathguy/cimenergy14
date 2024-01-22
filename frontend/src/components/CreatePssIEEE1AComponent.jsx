import React, { Component } from 'react'
import PssIEEE1AService from '../services/PssIEEE1AService';

class CreatePssIEEE1AComponent extends Component {
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
            PssIEEE1AService.getPssIEEE1AById(this.state.id).then( (res) =>{
                let pssIEEE1A = res.data;
                this.setState({
                    inputSignalType: pssIEEE1A.inputSignalType
                });
            });
        }        
    }
    saveOrUpdatePssIEEE1A = (e) => {
        e.preventDefault();
        let pssIEEE1A = {
                pssIEEE1AId: this.state.id,
                inputSignalType: this.state.inputSignalType
            };
        console.log('pssIEEE1A => ' + JSON.stringify(pssIEEE1A));

        // step 5
        if(this.state.id === '_add'){
            pssIEEE1A.pssIEEE1AId=''
            PssIEEE1AService.createPssIEEE1A(pssIEEE1A).then(res =>{
                this.props.history.push('/pssIEEE1As');
            });
        }else{
            PssIEEE1AService.updatePssIEEE1A(pssIEEE1A).then( res => {
                this.props.history.push('/pssIEEE1As');
            });
        }
    }
    
    changeInputSignalTypeHandler= (event) => {
        this.setState({inputSignalType: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssIEEE1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssIEEE1A</h3>
        }else{
            return <h3 className="text-center">Update PssIEEE1A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssIEEE1A}>Save</button>
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

export default CreatePssIEEE1AComponent
