import React, { Component } from 'react'
import GovSteamIEEE1Service from '../services/GovSteamIEEE1Service';

class CreateGovSteamIEEE1Component extends Component {
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
            GovSteamIEEE1Service.getGovSteamIEEE1ById(this.state.id).then( (res) =>{
                let govSteamIEEE1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteamIEEE1 = (e) => {
        e.preventDefault();
        let govSteamIEEE1 = {
                govSteamIEEE1Id: this.state.id,
            };
        console.log('govSteamIEEE1 => ' + JSON.stringify(govSteamIEEE1));

        // step 5
        if(this.state.id === '_add'){
            govSteamIEEE1.govSteamIEEE1Id=''
            GovSteamIEEE1Service.createGovSteamIEEE1(govSteamIEEE1).then(res =>{
                this.props.history.push('/govSteamIEEE1s');
            });
        }else{
            GovSteamIEEE1Service.updateGovSteamIEEE1(govSteamIEEE1).then( res => {
                this.props.history.push('/govSteamIEEE1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteamIEEE1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteamIEEE1</h3>
        }else{
            return <h3 className="text-center">Update GovSteamIEEE1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteamIEEE1}>Save</button>
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

export default CreateGovSteamIEEE1Component
