import React, { Component } from 'react'
import PssIEEE1AService from '../services/PssIEEE1AService';

class UpdatePssIEEE1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                inputSignalType: ''
        }
        this.updatePssIEEE1A = this.updatePssIEEE1A.bind(this);

        this.changeInputSignalTypeHandler = this.changeInputSignalTypeHandler.bind(this);
    }

    componentDidMount(){
        PssIEEE1AService.getPssIEEE1AById(this.state.id).then( (res) =>{
            let pssIEEE1A = res.data;
            this.setState({
                inputSignalType: pssIEEE1A.inputSignalType
            });
        });
    }

    updatePssIEEE1A = (e) => {
        e.preventDefault();
        let pssIEEE1A = {
            pssIEEE1AId: this.state.id,
            inputSignalType: this.state.inputSignalType
        };
        console.log('pssIEEE1A => ' + JSON.stringify(pssIEEE1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssIEEE1AService.updatePssIEEE1A(pssIEEE1A).then( res => {
            this.props.history.push('/pssIEEE1As');
        });
    }

    changeInputSignalTypeHandler= (event) => {
        this.setState({inputSignalType: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssIEEE1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssIEEE1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> InputSignalType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssIEEE1A}>Save</button>
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

export default UpdatePssIEEE1AComponent
