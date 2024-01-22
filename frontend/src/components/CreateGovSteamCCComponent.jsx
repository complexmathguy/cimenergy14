import React, { Component } from 'react'
import GovSteamCCService from '../services/GovSteamCCService';

class CreateGovSteamCCComponent extends Component {
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
            GovSteamCCService.getGovSteamCCById(this.state.id).then( (res) =>{
                let govSteamCC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteamCC = (e) => {
        e.preventDefault();
        let govSteamCC = {
                govSteamCCId: this.state.id,
            };
        console.log('govSteamCC => ' + JSON.stringify(govSteamCC));

        // step 5
        if(this.state.id === '_add'){
            govSteamCC.govSteamCCId=''
            GovSteamCCService.createGovSteamCC(govSteamCC).then(res =>{
                this.props.history.push('/govSteamCCs');
            });
        }else{
            GovSteamCCService.updateGovSteamCC(govSteamCC).then( res => {
                this.props.history.push('/govSteamCCs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteamCCs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteamCC</h3>
        }else{
            return <h3 className="text-center">Update GovSteamCC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteamCC}>Save</button>
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

export default CreateGovSteamCCComponent
