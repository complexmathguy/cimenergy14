import React, { Component } from 'react'
import GovCT1Service from '../services/GovCT1Service';

class UpdateGovCT1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                rselect: ''
        }
        this.updateGovCT1 = this.updateGovCT1.bind(this);

        this.changeRselectHandler = this.changeRselectHandler.bind(this);
    }

    componentDidMount(){
        GovCT1Service.getGovCT1ById(this.state.id).then( (res) =>{
            let govCT1 = res.data;
            this.setState({
                rselect: govCT1.rselect
            });
        });
    }

    updateGovCT1 = (e) => {
        e.preventDefault();
        let govCT1 = {
            govCT1Id: this.state.id,
            rselect: this.state.rselect
        };
        console.log('govCT1 => ' + JSON.stringify(govCT1));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovCT1Service.updateGovCT1(govCT1).then( res => {
            this.props.history.push('/govCT1s');
        });
    }

    changeRselectHandler= (event) => {
        this.setState({rselect: event.target.value});
    }

    cancel(){
        this.props.history.push('/govCT1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovCT1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Rselect: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovCT1}>Save</button>
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

export default UpdateGovCT1Component
