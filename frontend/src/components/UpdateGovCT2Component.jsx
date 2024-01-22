import React, { Component } from 'react'
import GovCT2Service from '../services/GovCT2Service';

class UpdateGovCT2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                rselect: ''
        }
        this.updateGovCT2 = this.updateGovCT2.bind(this);

        this.changeRselectHandler = this.changeRselectHandler.bind(this);
    }

    componentDidMount(){
        GovCT2Service.getGovCT2ById(this.state.id).then( (res) =>{
            let govCT2 = res.data;
            this.setState({
                rselect: govCT2.rselect
            });
        });
    }

    updateGovCT2 = (e) => {
        e.preventDefault();
        let govCT2 = {
            govCT2Id: this.state.id,
            rselect: this.state.rselect
        };
        console.log('govCT2 => ' + JSON.stringify(govCT2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovCT2Service.updateGovCT2(govCT2).then( res => {
            this.props.history.push('/govCT2s');
        });
    }

    changeRselectHandler= (event) => {
        this.setState({rselect: event.target.value});
    }

    cancel(){
        this.props.history.push('/govCT2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovCT2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Rselect: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovCT2}>Save</button>
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

export default UpdateGovCT2Component
