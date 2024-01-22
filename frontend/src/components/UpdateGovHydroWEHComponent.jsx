import React, { Component } from 'react'
import GovHydroWEHService from '../services/GovHydroWEHService';

class UpdateGovHydroWEHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydroWEH = this.updateGovHydroWEH.bind(this);

    }

    componentDidMount(){
        GovHydroWEHService.getGovHydroWEHById(this.state.id).then( (res) =>{
            let govHydroWEH = res.data;
            this.setState({
            });
        });
    }

    updateGovHydroWEH = (e) => {
        e.preventDefault();
        let govHydroWEH = {
            govHydroWEHId: this.state.id,
        };
        console.log('govHydroWEH => ' + JSON.stringify(govHydroWEH));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroWEHService.updateGovHydroWEH(govHydroWEH).then( res => {
            this.props.history.push('/govHydroWEHs');
        });
    }


    cancel(){
        this.props.history.push('/govHydroWEHs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroWEH</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroWEH}>Save</button>
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

export default UpdateGovHydroWEHComponent
