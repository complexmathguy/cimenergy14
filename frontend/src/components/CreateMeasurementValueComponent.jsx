import React, { Component } from 'react'
import MeasurementValueService from '../services/MeasurementValueService';

class CreateMeasurementValueComponent extends Component {
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
            MeasurementValueService.getMeasurementValueById(this.state.id).then( (res) =>{
                let measurementValue = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateMeasurementValue = (e) => {
        e.preventDefault();
        let measurementValue = {
                measurementValueId: this.state.id,
            };
        console.log('measurementValue => ' + JSON.stringify(measurementValue));

        // step 5
        if(this.state.id === '_add'){
            measurementValue.measurementValueId=''
            MeasurementValueService.createMeasurementValue(measurementValue).then(res =>{
                this.props.history.push('/measurementValues');
            });
        }else{
            MeasurementValueService.updateMeasurementValue(measurementValue).then( res => {
                this.props.history.push('/measurementValues');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/measurementValues');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MeasurementValue</h3>
        }else{
            return <h3 className="text-center">Update MeasurementValue</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMeasurementValue}>Save</button>
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

export default CreateMeasurementValueComponent
