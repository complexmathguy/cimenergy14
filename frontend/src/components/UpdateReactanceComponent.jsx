import React, { Component } from 'react'
import ReactanceService from '../services/ReactanceService';

class UpdateReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateReactance = this.updateReactance.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        ReactanceService.getReactanceById(this.state.id).then( (res) =>{
            let reactance = res.data;
            this.setState({
                multiplier: reactance.multiplier,
                unit: reactance.unit
            });
        });
    }

    updateReactance = (e) => {
        e.preventDefault();
        let reactance = {
            reactanceId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('reactance => ' + JSON.stringify(reactance));
        console.log('id => ' + JSON.stringify(this.state.id));
        ReactanceService.updateReactance(reactance).then( res => {
            this.props.history.push('/reactances');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/reactances');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Reactance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateReactance}>Save</button>
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

export default UpdateReactanceComponent
