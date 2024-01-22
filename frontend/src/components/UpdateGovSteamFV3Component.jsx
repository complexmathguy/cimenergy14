import React, { Component } from 'react'
import GovSteamFV3Service from '../services/GovSteamFV3Service';

class UpdateGovSteamFV3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteamFV3 = this.updateGovSteamFV3.bind(this);

    }

    componentDidMount(){
        GovSteamFV3Service.getGovSteamFV3ById(this.state.id).then( (res) =>{
            let govSteamFV3 = res.data;
            this.setState({
            });
        });
    }

    updateGovSteamFV3 = (e) => {
        e.preventDefault();
        let govSteamFV3 = {
            govSteamFV3Id: this.state.id,
        };
        console.log('govSteamFV3 => ' + JSON.stringify(govSteamFV3));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamFV3Service.updateGovSteamFV3(govSteamFV3).then( res => {
            this.props.history.push('/govSteamFV3s');
        });
    }


    cancel(){
        this.props.history.push('/govSteamFV3s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamFV3</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamFV3}>Save</button>
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

export default UpdateGovSteamFV3Component
