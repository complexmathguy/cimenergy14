import React, { Component } from 'react'
import GovSteamFV2Service from '../services/GovSteamFV2Service';

class CreateGovSteamFV2Component extends Component {
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
            GovSteamFV2Service.getGovSteamFV2ById(this.state.id).then( (res) =>{
                let govSteamFV2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteamFV2 = (e) => {
        e.preventDefault();
        let govSteamFV2 = {
                govSteamFV2Id: this.state.id,
            };
        console.log('govSteamFV2 => ' + JSON.stringify(govSteamFV2));

        // step 5
        if(this.state.id === '_add'){
            govSteamFV2.govSteamFV2Id=''
            GovSteamFV2Service.createGovSteamFV2(govSteamFV2).then(res =>{
                this.props.history.push('/govSteamFV2s');
            });
        }else{
            GovSteamFV2Service.updateGovSteamFV2(govSteamFV2).then( res => {
                this.props.history.push('/govSteamFV2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteamFV2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteamFV2</h3>
        }else{
            return <h3 className="text-center">Update GovSteamFV2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteamFV2}>Save</button>
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

export default CreateGovSteamFV2Component
