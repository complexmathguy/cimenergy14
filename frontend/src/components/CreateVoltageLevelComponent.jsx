import React, { Component } from 'react'
import VoltageLevelService from '../services/VoltageLevelService';

class CreateVoltageLevelComponent extends Component {
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
            VoltageLevelService.getVoltageLevelById(this.state.id).then( (res) =>{
                let voltageLevel = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateVoltageLevel = (e) => {
        e.preventDefault();
        let voltageLevel = {
                voltageLevelId: this.state.id,
            };
        console.log('voltageLevel => ' + JSON.stringify(voltageLevel));

        // step 5
        if(this.state.id === '_add'){
            voltageLevel.voltageLevelId=''
            VoltageLevelService.createVoltageLevel(voltageLevel).then(res =>{
                this.props.history.push('/voltageLevels');
            });
        }else{
            VoltageLevelService.updateVoltageLevel(voltageLevel).then( res => {
                this.props.history.push('/voltageLevels');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/voltageLevels');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VoltageLevel</h3>
        }else{
            return <h3 className="text-center">Update VoltageLevel</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVoltageLevel}>Save</button>
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

export default CreateVoltageLevelComponent
