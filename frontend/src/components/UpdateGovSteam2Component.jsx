import React, { Component } from 'react'
import GovSteam2Service from '../services/GovSteam2Service';

class UpdateGovSteam2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteam2 = this.updateGovSteam2.bind(this);

    }

    componentDidMount(){
        GovSteam2Service.getGovSteam2ById(this.state.id).then( (res) =>{
            let govSteam2 = res.data;
            this.setState({
            });
        });
    }

    updateGovSteam2 = (e) => {
        e.preventDefault();
        let govSteam2 = {
            govSteam2Id: this.state.id,
        };
        console.log('govSteam2 => ' + JSON.stringify(govSteam2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteam2Service.updateGovSteam2(govSteam2).then( res => {
            this.props.history.push('/govSteam2s');
        });
    }


    cancel(){
        this.props.history.push('/govSteam2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteam2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteam2}>Save</button>
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

export default UpdateGovSteam2Component
