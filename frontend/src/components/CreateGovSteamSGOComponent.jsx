import React, { Component } from 'react'
import GovSteamSGOService from '../services/GovSteamSGOService';

class CreateGovSteamSGOComponent extends Component {
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
            GovSteamSGOService.getGovSteamSGOById(this.state.id).then( (res) =>{
                let govSteamSGO = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteamSGO = (e) => {
        e.preventDefault();
        let govSteamSGO = {
                govSteamSGOId: this.state.id,
            };
        console.log('govSteamSGO => ' + JSON.stringify(govSteamSGO));

        // step 5
        if(this.state.id === '_add'){
            govSteamSGO.govSteamSGOId=''
            GovSteamSGOService.createGovSteamSGO(govSteamSGO).then(res =>{
                this.props.history.push('/govSteamSGOs');
            });
        }else{
            GovSteamSGOService.updateGovSteamSGO(govSteamSGO).then( res => {
                this.props.history.push('/govSteamSGOs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteamSGOs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteamSGO</h3>
        }else{
            return <h3 className="text-center">Update GovSteamSGO</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteamSGO}>Save</button>
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

export default CreateGovSteamSGOComponent
