import React, { Component } from 'react'
import LoadResponseCharacteristicService from '../services/LoadResponseCharacteristicService';

class CreateLoadResponseCharacteristicComponent extends Component {
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
            LoadResponseCharacteristicService.getLoadResponseCharacteristicById(this.state.id).then( (res) =>{
                let loadResponseCharacteristic = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLoadResponseCharacteristic = (e) => {
        e.preventDefault();
        let loadResponseCharacteristic = {
                loadResponseCharacteristicId: this.state.id,
            };
        console.log('loadResponseCharacteristic => ' + JSON.stringify(loadResponseCharacteristic));

        // step 5
        if(this.state.id === '_add'){
            loadResponseCharacteristic.loadResponseCharacteristicId=''
            LoadResponseCharacteristicService.createLoadResponseCharacteristic(loadResponseCharacteristic).then(res =>{
                this.props.history.push('/loadResponseCharacteristics');
            });
        }else{
            LoadResponseCharacteristicService.updateLoadResponseCharacteristic(loadResponseCharacteristic).then( res => {
                this.props.history.push('/loadResponseCharacteristics');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/loadResponseCharacteristics');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadResponseCharacteristic</h3>
        }else{
            return <h3 className="text-center">Update LoadResponseCharacteristic</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadResponseCharacteristic}>Save</button>
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

export default CreateLoadResponseCharacteristicComponent
