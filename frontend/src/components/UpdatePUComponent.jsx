import React, { Component } from 'react'
import PUService from '../services/PUService';

class UpdatePUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updatePU = this.updatePU.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        PUService.getPUById(this.state.id).then( (res) =>{
            let pU = res.data;
            this.setState({
                multiplier: pU.multiplier,
                unit: pU.unit
            });
        });
    }

    updatePU = (e) => {
        e.preventDefault();
        let pU = {
            pUId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('pU => ' + JSON.stringify(pU));
        console.log('id => ' + JSON.stringify(this.state.id));
        PUService.updatePU(pU).then( res => {
            this.props.history.push('/pUs');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/pUs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PU</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePU}>Save</button>
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

export default UpdatePUComponent
