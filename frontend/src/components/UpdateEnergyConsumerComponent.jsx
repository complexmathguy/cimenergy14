import React, { Component } from 'react'
import EnergyConsumerService from '../services/EnergyConsumerService';

class UpdateEnergyConsumerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEnergyConsumer = this.updateEnergyConsumer.bind(this);

    }

    componentDidMount(){
        EnergyConsumerService.getEnergyConsumerById(this.state.id).then( (res) =>{
            let energyConsumer = res.data;
            this.setState({
            });
        });
    }

    updateEnergyConsumer = (e) => {
        e.preventDefault();
        let energyConsumer = {
            energyConsumerId: this.state.id,
        };
        console.log('energyConsumer => ' + JSON.stringify(energyConsumer));
        console.log('id => ' + JSON.stringify(this.state.id));
        EnergyConsumerService.updateEnergyConsumer(energyConsumer).then( res => {
            this.props.history.push('/energyConsumers');
        });
    }


    cancel(){
        this.props.history.push('/energyConsumers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EnergyConsumer</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEnergyConsumer}>Save</button>
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

export default UpdateEnergyConsumerComponent
