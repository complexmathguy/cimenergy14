import React, { Component } from 'react'
import PerCentService from '../services/PerCentService';

class UpdatePerCentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updatePerCent = this.updatePerCent.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        PerCentService.getPerCentById(this.state.id).then( (res) =>{
            let perCent = res.data;
            this.setState({
                multiplier: perCent.multiplier,
                unit: perCent.unit
            });
        });
    }

    updatePerCent = (e) => {
        e.preventDefault();
        let perCent = {
            perCentId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('perCent => ' + JSON.stringify(perCent));
        console.log('id => ' + JSON.stringify(this.state.id));
        PerCentService.updatePerCent(perCent).then( res => {
            this.props.history.push('/perCents');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/perCents');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PerCent</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePerCent}>Save</button>
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

export default UpdatePerCentComponent
