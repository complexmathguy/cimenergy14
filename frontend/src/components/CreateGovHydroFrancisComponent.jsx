import React, { Component } from 'react'
import GovHydroFrancisService from '../services/GovHydroFrancisService';

class CreateGovHydroFrancisComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                governorControl: ''
        }
        this.changeGovernorControlHandler = this.changeGovernorControlHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovHydroFrancisService.getGovHydroFrancisById(this.state.id).then( (res) =>{
                let govHydroFrancis = res.data;
                this.setState({
                    governorControl: govHydroFrancis.governorControl
                });
            });
        }        
    }
    saveOrUpdateGovHydroFrancis = (e) => {
        e.preventDefault();
        let govHydroFrancis = {
                govHydroFrancisId: this.state.id,
                governorControl: this.state.governorControl
            };
        console.log('govHydroFrancis => ' + JSON.stringify(govHydroFrancis));

        // step 5
        if(this.state.id === '_add'){
            govHydroFrancis.govHydroFrancisId=''
            GovHydroFrancisService.createGovHydroFrancis(govHydroFrancis).then(res =>{
                this.props.history.push('/govHydroFranciss');
            });
        }else{
            GovHydroFrancisService.updateGovHydroFrancis(govHydroFrancis).then( res => {
                this.props.history.push('/govHydroFranciss');
            });
        }
    }
    
    changeGovernorControlHandler= (event) => {
        this.setState({governorControl: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroFranciss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroFrancis</h3>
        }else{
            return <h3 className="text-center">Update GovHydroFrancis</h3>
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
                                            <label> GovernorControl: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroFrancis}>Save</button>
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

export default CreateGovHydroFrancisComponent
