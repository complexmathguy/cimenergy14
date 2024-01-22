import React, { Component } from 'react'
import GovSteamFV3Service from '../services/GovSteamFV3Service';

class CreateGovSteamFV3Component extends Component {
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
            GovSteamFV3Service.getGovSteamFV3ById(this.state.id).then( (res) =>{
                let govSteamFV3 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteamFV3 = (e) => {
        e.preventDefault();
        let govSteamFV3 = {
                govSteamFV3Id: this.state.id,
            };
        console.log('govSteamFV3 => ' + JSON.stringify(govSteamFV3));

        // step 5
        if(this.state.id === '_add'){
            govSteamFV3.govSteamFV3Id=''
            GovSteamFV3Service.createGovSteamFV3(govSteamFV3).then(res =>{
                this.props.history.push('/govSteamFV3s');
            });
        }else{
            GovSteamFV3Service.updateGovSteamFV3(govSteamFV3).then( res => {
                this.props.history.push('/govSteamFV3s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteamFV3s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteamFV3</h3>
        }else{
            return <h3 className="text-center">Update GovSteamFV3</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteamFV3}>Save</button>
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

export default CreateGovSteamFV3Component
