import React, { Component } from 'react'
import ActivePowerLimitService from '../services/ActivePowerLimitService';

class UpdateActivePowerLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateActivePowerLimit = this.updateActivePowerLimit.bind(this);

    }

    componentDidMount(){
        ActivePowerLimitService.getActivePowerLimitById(this.state.id).then( (res) =>{
            let activePowerLimit = res.data;
            this.setState({
            });
        });
    }

    updateActivePowerLimit = (e) => {
        e.preventDefault();
        let activePowerLimit = {
            activePowerLimitId: this.state.id,
        };
        console.log('activePowerLimit => ' + JSON.stringify(activePowerLimit));
        console.log('id => ' + JSON.stringify(this.state.id));
        ActivePowerLimitService.updateActivePowerLimit(activePowerLimit).then( res => {
            this.props.history.push('/activePowerLimits');
        });
    }


    cancel(){
        this.props.history.push('/activePowerLimits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ActivePowerLimit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateActivePowerLimit}>Save</button>
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

export default UpdateActivePowerLimitComponent
