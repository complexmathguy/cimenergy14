import React, { Component } from 'react'
import GovSteamCCService from '../services/GovSteamCCService';

class UpdateGovSteamCCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteamCC = this.updateGovSteamCC.bind(this);

    }

    componentDidMount(){
        GovSteamCCService.getGovSteamCCById(this.state.id).then( (res) =>{
            let govSteamCC = res.data;
            this.setState({
            });
        });
    }

    updateGovSteamCC = (e) => {
        e.preventDefault();
        let govSteamCC = {
            govSteamCCId: this.state.id,
        };
        console.log('govSteamCC => ' + JSON.stringify(govSteamCC));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamCCService.updateGovSteamCC(govSteamCC).then( res => {
            this.props.history.push('/govSteamCCs');
        });
    }


    cancel(){
        this.props.history.push('/govSteamCCs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamCC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamCC}>Save</button>
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

export default UpdateGovSteamCCComponent
