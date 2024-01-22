import React, { Component } from 'react'
import MoneyService from '../services/MoneyService';

class UpdateMoneyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateMoney = this.updateMoney.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        MoneyService.getMoneyById(this.state.id).then( (res) =>{
            let money = res.data;
            this.setState({
                multiplier: money.multiplier,
                unit: money.unit
            });
        });
    }

    updateMoney = (e) => {
        e.preventDefault();
        let money = {
            moneyId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('money => ' + JSON.stringify(money));
        console.log('id => ' + JSON.stringify(this.state.id));
        MoneyService.updateMoney(money).then( res => {
            this.props.history.push('/moneys');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/moneys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Money</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMoney}>Save</button>
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

export default UpdateMoneyComponent
