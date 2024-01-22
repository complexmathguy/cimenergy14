import React, { Component } from 'react'
import GovHydroWPIDService from '../services/GovHydroWPIDService';

class CreateGovHydroWPIDComponent extends Component {
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
            GovHydroWPIDService.getGovHydroWPIDById(this.state.id).then( (res) =>{
                let govHydroWPID = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroWPID = (e) => {
        e.preventDefault();
        let govHydroWPID = {
                govHydroWPIDId: this.state.id,
            };
        console.log('govHydroWPID => ' + JSON.stringify(govHydroWPID));

        // step 5
        if(this.state.id === '_add'){
            govHydroWPID.govHydroWPIDId=''
            GovHydroWPIDService.createGovHydroWPID(govHydroWPID).then(res =>{
                this.props.history.push('/govHydroWPIDs');
            });
        }else{
            GovHydroWPIDService.updateGovHydroWPID(govHydroWPID).then( res => {
                this.props.history.push('/govHydroWPIDs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroWPIDs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroWPID</h3>
        }else{
            return <h3 className="text-center">Update GovHydroWPID</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroWPID}>Save</button>
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

export default CreateGovHydroWPIDComponent
