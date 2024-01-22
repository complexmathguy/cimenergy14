import React, { Component } from 'react'
import MeasurementValueService from '../services/MeasurementValueService';

class UpdateMeasurementValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateMeasurementValue = this.updateMeasurementValue.bind(this);

    }

    componentDidMount(){
        MeasurementValueService.getMeasurementValueById(this.state.id).then( (res) =>{
            let measurementValue = res.data;
            this.setState({
            });
        });
    }

    updateMeasurementValue = (e) => {
        e.preventDefault();
        let measurementValue = {
            measurementValueId: this.state.id,
        };
        console.log('measurementValue => ' + JSON.stringify(measurementValue));
        console.log('id => ' + JSON.stringify(this.state.id));
        MeasurementValueService.updateMeasurementValue(measurementValue).then( res => {
            this.props.history.push('/measurementValues');
        });
    }


    cancel(){
        this.props.history.push('/measurementValues');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MeasurementValue</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMeasurementValue}>Save</button>
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

export default UpdateMeasurementValueComponent
