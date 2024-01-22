import React, { Component } from 'react'
import GovHydroFrancisService from '../services/GovHydroFrancisService';

class UpdateGovHydroFrancisComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                governorControl: ''
        }
        this.updateGovHydroFrancis = this.updateGovHydroFrancis.bind(this);

        this.changeGovernorControlHandler = this.changeGovernorControlHandler.bind(this);
    }

    componentDidMount(){
        GovHydroFrancisService.getGovHydroFrancisById(this.state.id).then( (res) =>{
            let govHydroFrancis = res.data;
            this.setState({
                governorControl: govHydroFrancis.governorControl
            });
        });
    }

    updateGovHydroFrancis = (e) => {
        e.preventDefault();
        let govHydroFrancis = {
            govHydroFrancisId: this.state.id,
            governorControl: this.state.governorControl
        };
        console.log('govHydroFrancis => ' + JSON.stringify(govHydroFrancis));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroFrancisService.updateGovHydroFrancis(govHydroFrancis).then( res => {
            this.props.history.push('/govHydroFranciss');
        });
    }

    changeGovernorControlHandler= (event) => {
        this.setState({governorControl: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroFranciss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroFrancis</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> GovernorControl: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroFrancis}>Save</button>
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

export default UpdateGovHydroFrancisComponent
