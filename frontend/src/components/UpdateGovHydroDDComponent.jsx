import React, { Component } from 'react'
import GovHydroDDService from '../services/GovHydroDDService';

class UpdateGovHydroDDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydroDD = this.updateGovHydroDD.bind(this);

    }

    componentDidMount(){
        GovHydroDDService.getGovHydroDDById(this.state.id).then( (res) =>{
            let govHydroDD = res.data;
            this.setState({
            });
        });
    }

    updateGovHydroDD = (e) => {
        e.preventDefault();
        let govHydroDD = {
            govHydroDDId: this.state.id,
        };
        console.log('govHydroDD => ' + JSON.stringify(govHydroDD));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroDDService.updateGovHydroDD(govHydroDD).then( res => {
            this.props.history.push('/govHydroDDs');
        });
    }


    cancel(){
        this.props.history.push('/govHydroDDs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroDD</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroDD}>Save</button>
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

export default UpdateGovHydroDDComponent
