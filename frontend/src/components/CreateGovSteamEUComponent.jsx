import React, { Component } from 'react'
import GovSteamEUService from '../services/GovSteamEUService';

class CreateGovSteamEUComponent extends Component {
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
            GovSteamEUService.getGovSteamEUById(this.state.id).then( (res) =>{
                let govSteamEU = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteamEU = (e) => {
        e.preventDefault();
        let govSteamEU = {
                govSteamEUId: this.state.id,
            };
        console.log('govSteamEU => ' + JSON.stringify(govSteamEU));

        // step 5
        if(this.state.id === '_add'){
            govSteamEU.govSteamEUId=''
            GovSteamEUService.createGovSteamEU(govSteamEU).then(res =>{
                this.props.history.push('/govSteamEUs');
            });
        }else{
            GovSteamEUService.updateGovSteamEU(govSteamEU).then( res => {
                this.props.history.push('/govSteamEUs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteamEUs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteamEU</h3>
        }else{
            return <h3 className="text-center">Update GovSteamEU</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteamEU}>Save</button>
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

export default CreateGovSteamEUComponent
