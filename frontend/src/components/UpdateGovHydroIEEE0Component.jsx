import React, { Component } from 'react'
import GovHydroIEEE0Service from '../services/GovHydroIEEE0Service';

class UpdateGovHydroIEEE0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydroIEEE0 = this.updateGovHydroIEEE0.bind(this);

    }

    componentDidMount(){
        GovHydroIEEE0Service.getGovHydroIEEE0ById(this.state.id).then( (res) =>{
            let govHydroIEEE0 = res.data;
            this.setState({
            });
        });
    }

    updateGovHydroIEEE0 = (e) => {
        e.preventDefault();
        let govHydroIEEE0 = {
            govHydroIEEE0Id: this.state.id,
        };
        console.log('govHydroIEEE0 => ' + JSON.stringify(govHydroIEEE0));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroIEEE0Service.updateGovHydroIEEE0(govHydroIEEE0).then( res => {
            this.props.history.push('/govHydroIEEE0s');
        });
    }


    cancel(){
        this.props.history.push('/govHydroIEEE0s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroIEEE0</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroIEEE0}>Save</button>
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

export default UpdateGovHydroIEEE0Component
