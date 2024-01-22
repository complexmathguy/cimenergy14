import React, { Component } from 'react'
import DCSeriesDeviceService from '../services/DCSeriesDeviceService';

class UpdateDCSeriesDeviceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCSeriesDevice = this.updateDCSeriesDevice.bind(this);

    }

    componentDidMount(){
        DCSeriesDeviceService.getDCSeriesDeviceById(this.state.id).then( (res) =>{
            let dCSeriesDevice = res.data;
            this.setState({
            });
        });
    }

    updateDCSeriesDevice = (e) => {
        e.preventDefault();
        let dCSeriesDevice = {
            dCSeriesDeviceId: this.state.id,
        };
        console.log('dCSeriesDevice => ' + JSON.stringify(dCSeriesDevice));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCSeriesDeviceService.updateDCSeriesDevice(dCSeriesDevice).then( res => {
            this.props.history.push('/dCSeriesDevices');
        });
    }


    cancel(){
        this.props.history.push('/dCSeriesDevices');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCSeriesDevice</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCSeriesDevice}>Save</button>
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

export default UpdateDCSeriesDeviceComponent
