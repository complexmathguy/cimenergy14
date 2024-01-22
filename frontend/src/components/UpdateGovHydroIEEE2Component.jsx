import React, { Component } from 'react'
import GovHydroIEEE2Service from '../services/GovHydroIEEE2Service';

class UpdateGovHydroIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydroIEEE2 = this.updateGovHydroIEEE2.bind(this);

    }

    componentDidMount(){
        GovHydroIEEE2Service.getGovHydroIEEE2ById(this.state.id).then( (res) =>{
            let govHydroIEEE2 = res.data;
            this.setState({
            });
        });
    }

    updateGovHydroIEEE2 = (e) => {
        e.preventDefault();
        let govHydroIEEE2 = {
            govHydroIEEE2Id: this.state.id,
        };
        console.log('govHydroIEEE2 => ' + JSON.stringify(govHydroIEEE2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroIEEE2Service.updateGovHydroIEEE2(govHydroIEEE2).then( res => {
            this.props.history.push('/govHydroIEEE2s');
        });
    }


    cancel(){
        this.props.history.push('/govHydroIEEE2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroIEEE2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroIEEE2}>Save</button>
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

export default UpdateGovHydroIEEE2Component
