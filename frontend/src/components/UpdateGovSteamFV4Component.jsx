import React, { Component } from 'react'
import GovSteamFV4Service from '../services/GovSteamFV4Service';

class UpdateGovSteamFV4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteamFV4 = this.updateGovSteamFV4.bind(this);

    }

    componentDidMount(){
        GovSteamFV4Service.getGovSteamFV4ById(this.state.id).then( (res) =>{
            let govSteamFV4 = res.data;
            this.setState({
            });
        });
    }

    updateGovSteamFV4 = (e) => {
        e.preventDefault();
        let govSteamFV4 = {
            govSteamFV4Id: this.state.id,
        };
        console.log('govSteamFV4 => ' + JSON.stringify(govSteamFV4));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamFV4Service.updateGovSteamFV4(govSteamFV4).then( res => {
            this.props.history.push('/govSteamFV4s');
        });
    }


    cancel(){
        this.props.history.push('/govSteamFV4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamFV4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamFV4}>Save</button>
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

export default UpdateGovSteamFV4Component
