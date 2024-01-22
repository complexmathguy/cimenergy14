import React, { Component } from 'react'
import GovHydroWPIDService from '../services/GovHydroWPIDService';

class UpdateGovHydroWPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydroWPID = this.updateGovHydroWPID.bind(this);

    }

    componentDidMount(){
        GovHydroWPIDService.getGovHydroWPIDById(this.state.id).then( (res) =>{
            let govHydroWPID = res.data;
            this.setState({
            });
        });
    }

    updateGovHydroWPID = (e) => {
        e.preventDefault();
        let govHydroWPID = {
            govHydroWPIDId: this.state.id,
        };
        console.log('govHydroWPID => ' + JSON.stringify(govHydroWPID));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroWPIDService.updateGovHydroWPID(govHydroWPID).then( res => {
            this.props.history.push('/govHydroWPIDs');
        });
    }


    cancel(){
        this.props.history.push('/govHydroWPIDs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroWPID</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroWPID}>Save</button>
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

export default UpdateGovHydroWPIDComponent
