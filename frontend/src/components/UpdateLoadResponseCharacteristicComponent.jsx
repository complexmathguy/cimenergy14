import React, { Component } from 'react'
import LoadResponseCharacteristicService from '../services/LoadResponseCharacteristicService';

class UpdateLoadResponseCharacteristicComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLoadResponseCharacteristic = this.updateLoadResponseCharacteristic.bind(this);

    }

    componentDidMount(){
        LoadResponseCharacteristicService.getLoadResponseCharacteristicById(this.state.id).then( (res) =>{
            let loadResponseCharacteristic = res.data;
            this.setState({
            });
        });
    }

    updateLoadResponseCharacteristic = (e) => {
        e.preventDefault();
        let loadResponseCharacteristic = {
            loadResponseCharacteristicId: this.state.id,
        };
        console.log('loadResponseCharacteristic => ' + JSON.stringify(loadResponseCharacteristic));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadResponseCharacteristicService.updateLoadResponseCharacteristic(loadResponseCharacteristic).then( res => {
            this.props.history.push('/loadResponseCharacteristics');
        });
    }


    cancel(){
        this.props.history.push('/loadResponseCharacteristics');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadResponseCharacteristic</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadResponseCharacteristic}>Save</button>
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

export default UpdateLoadResponseCharacteristicComponent
