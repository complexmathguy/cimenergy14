import React, { Component } from 'react'
import GovSteamFV4Service from '../services/GovSteamFV4Service';

class CreateGovSteamFV4Component extends Component {
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
            GovSteamFV4Service.getGovSteamFV4ById(this.state.id).then( (res) =>{
                let govSteamFV4 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteamFV4 = (e) => {
        e.preventDefault();
        let govSteamFV4 = {
                govSteamFV4Id: this.state.id,
            };
        console.log('govSteamFV4 => ' + JSON.stringify(govSteamFV4));

        // step 5
        if(this.state.id === '_add'){
            govSteamFV4.govSteamFV4Id=''
            GovSteamFV4Service.createGovSteamFV4(govSteamFV4).then(res =>{
                this.props.history.push('/govSteamFV4s');
            });
        }else{
            GovSteamFV4Service.updateGovSteamFV4(govSteamFV4).then( res => {
                this.props.history.push('/govSteamFV4s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteamFV4s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteamFV4</h3>
        }else{
            return <h3 className="text-center">Update GovSteamFV4</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteamFV4}>Save</button>
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

export default CreateGovSteamFV4Component
