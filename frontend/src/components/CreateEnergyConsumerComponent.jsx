import React, { Component } from 'react'
import EnergyConsumerService from '../services/EnergyConsumerService';

class CreateEnergyConsumerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            EnergyConsumerService.getEnergyConsumerById(this.state.id).then( (res) =>{
                let energyConsumer = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEnergyConsumer = (e) => {
        e.preventDefault();
        let energyConsumer = {
                energyConsumerId: this.state.id,
            };
        console.log('energyConsumer => ' + JSON.stringify(energyConsumer));

        // step 5
        if(this.state.id === '_add'){
            energyConsumer.energyConsumerId=''
            EnergyConsumerService.createEnergyConsumer(energyConsumer).then(res =>{
                this.props.history.push('/energyConsumers');
            });
        }else{
            EnergyConsumerService.updateEnergyConsumer(energyConsumer).then( res => {
                this.props.history.push('/energyConsumers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/energyConsumers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EnergyConsumer</h3>
        }else{
            return <h3 className="text-center">Update EnergyConsumer</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEnergyConsumer}>Save</button>
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

export default CreateEnergyConsumerComponent
