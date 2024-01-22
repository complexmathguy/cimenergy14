import React, { Component } from 'react'
import GovSteamFV2Service from '../services/GovSteamFV2Service';

class UpdateGovSteamFV2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteamFV2 = this.updateGovSteamFV2.bind(this);

    }

    componentDidMount(){
        GovSteamFV2Service.getGovSteamFV2ById(this.state.id).then( (res) =>{
            let govSteamFV2 = res.data;
            this.setState({
            });
        });
    }

    updateGovSteamFV2 = (e) => {
        e.preventDefault();
        let govSteamFV2 = {
            govSteamFV2Id: this.state.id,
        };
        console.log('govSteamFV2 => ' + JSON.stringify(govSteamFV2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamFV2Service.updateGovSteamFV2(govSteamFV2).then( res => {
            this.props.history.push('/govSteamFV2s');
        });
    }


    cancel(){
        this.props.history.push('/govSteamFV2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamFV2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamFV2}>Save</button>
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

export default UpdateGovSteamFV2Component
