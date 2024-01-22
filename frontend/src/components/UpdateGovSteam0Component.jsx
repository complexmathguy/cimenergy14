import React, { Component } from 'react'
import GovSteam0Service from '../services/GovSteam0Service';

class UpdateGovSteam0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteam0 = this.updateGovSteam0.bind(this);

    }

    componentDidMount(){
        GovSteam0Service.getGovSteam0ById(this.state.id).then( (res) =>{
            let govSteam0 = res.data;
            this.setState({
            });
        });
    }

    updateGovSteam0 = (e) => {
        e.preventDefault();
        let govSteam0 = {
            govSteam0Id: this.state.id,
        };
        console.log('govSteam0 => ' + JSON.stringify(govSteam0));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteam0Service.updateGovSteam0(govSteam0).then( res => {
            this.props.history.push('/govSteam0s');
        });
    }


    cancel(){
        this.props.history.push('/govSteam0s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteam0</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteam0}>Save</button>
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

export default UpdateGovSteam0Component
