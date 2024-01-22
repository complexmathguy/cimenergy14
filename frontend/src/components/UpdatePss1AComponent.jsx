import React, { Component } from 'react'
import Pss1AService from '../services/Pss1AService';

class UpdatePss1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inputSignalType: ''
        }
        this.updatePss1A = this.updatePss1A.bind(this);

        this.changeInputSignalTypeHandler = this.changeInputSignalTypeHandler.bind(this);
    }

    componentDidMount(){
        Pss1AService.getPss1AById(this.state.id).then( (res) =>{
            let pss1A = res.data;
            this.setState({
                inputSignalType: pss1A.inputSignalType
            });
        });
    }

    updatePss1A = (e) => {
        e.preventDefault();
        let pss1A = {
            pss1AId: this.state.id,
            inputSignalType: this.state.inputSignalType
        };
        console.log('pss1A => ' + JSON.stringify(pss1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        Pss1AService.updatePss1A(pss1A).then( res => {
            this.props.history.push('/pss1As');
        });
    }

    changeInputSignalTypeHandler= (event) => {
        this.setState({inputSignalType: event.target.value});
    }

    cancel(){
        this.props.history.push('/pss1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Pss1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> InputSignalType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePss1A}>Save</button>
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

export default UpdatePss1AComponent
