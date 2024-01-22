import React, { Component } from 'react'
import GovSteamIEEE1Service from '../services/GovSteamIEEE1Service';

class UpdateGovSteamIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteamIEEE1 = this.updateGovSteamIEEE1.bind(this);

    }

    componentDidMount(){
        GovSteamIEEE1Service.getGovSteamIEEE1ById(this.state.id).then( (res) =>{
            let govSteamIEEE1 = res.data;
            this.setState({
            });
        });
    }

    updateGovSteamIEEE1 = (e) => {
        e.preventDefault();
        let govSteamIEEE1 = {
            govSteamIEEE1Id: this.state.id,
        };
        console.log('govSteamIEEE1 => ' + JSON.stringify(govSteamIEEE1));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamIEEE1Service.updateGovSteamIEEE1(govSteamIEEE1).then( res => {
            this.props.history.push('/govSteamIEEE1s');
        });
    }


    cancel(){
        this.props.history.push('/govSteamIEEE1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamIEEE1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamIEEE1}>Save</button>
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

export default UpdateGovSteamIEEE1Component
