import React, { Component } from 'react'
import GovSteamSGOService from '../services/GovSteamSGOService';

class UpdateGovSteamSGOComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteamSGO = this.updateGovSteamSGO.bind(this);

    }

    componentDidMount(){
        GovSteamSGOService.getGovSteamSGOById(this.state.id).then( (res) =>{
            let govSteamSGO = res.data;
            this.setState({
            });
        });
    }

    updateGovSteamSGO = (e) => {
        e.preventDefault();
        let govSteamSGO = {
            govSteamSGOId: this.state.id,
        };
        console.log('govSteamSGO => ' + JSON.stringify(govSteamSGO));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamSGOService.updateGovSteamSGO(govSteamSGO).then( res => {
            this.props.history.push('/govSteamSGOs');
        });
    }


    cancel(){
        this.props.history.push('/govSteamSGOs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamSGO</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamSGO}>Save</button>
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

export default UpdateGovSteamSGOComponent
