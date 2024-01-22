import React, { Component } from 'react'
import GovSteamEUService from '../services/GovSteamEUService';

class UpdateGovSteamEUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteamEU = this.updateGovSteamEU.bind(this);

    }

    componentDidMount(){
        GovSteamEUService.getGovSteamEUById(this.state.id).then( (res) =>{
            let govSteamEU = res.data;
            this.setState({
            });
        });
    }

    updateGovSteamEU = (e) => {
        e.preventDefault();
        let govSteamEU = {
            govSteamEUId: this.state.id,
        };
        console.log('govSteamEU => ' + JSON.stringify(govSteamEU));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamEUService.updateGovSteamEU(govSteamEU).then( res => {
            this.props.history.push('/govSteamEUs');
        });
    }


    cancel(){
        this.props.history.push('/govSteamEUs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamEU</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamEU}>Save</button>
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

export default UpdateGovSteamEUComponent
