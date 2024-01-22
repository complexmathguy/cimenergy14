import React, { Component } from 'react'
import WindContQIECService from '../services/WindContQIECService';

class UpdateWindContQIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                windLVRTQcontrolModesType: '',
                windQcontrolModesType: ''
        }
        this.updateWindContQIEC = this.updateWindContQIEC.bind(this);

        this.changeWindLVRTQcontrolModesTypeHandler = this.changeWindLVRTQcontrolModesTypeHandler.bind(this);
        this.changeWindQcontrolModesTypeHandler = this.changeWindQcontrolModesTypeHandler.bind(this);
    }

    componentDidMount(){
        WindContQIECService.getWindContQIECById(this.state.id).then( (res) =>{
            let windContQIEC = res.data;
            this.setState({
                windLVRTQcontrolModesType: windContQIEC.windLVRTQcontrolModesType,
                windQcontrolModesType: windContQIEC.windQcontrolModesType
            });
        });
    }

    updateWindContQIEC = (e) => {
        e.preventDefault();
        let windContQIEC = {
            windContQIECId: this.state.id,
            windLVRTQcontrolModesType: this.state.windLVRTQcontrolModesType,
            windQcontrolModesType: this.state.windQcontrolModesType
        };
        console.log('windContQIEC => ' + JSON.stringify(windContQIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContQIECService.updateWindContQIEC(windContQIEC).then( res => {
            this.props.history.push('/windContQIECs');
        });
    }

    changeWindLVRTQcontrolModesTypeHandler= (event) => {
        this.setState({windLVRTQcontrolModesType: event.target.value});
    }
    changeWindQcontrolModesTypeHandler= (event) => {
        this.setState({windQcontrolModesType: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContQIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContQIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> WindLVRTQcontrolModesType: </label>
                                            #formFields( $attribute, 'update')
                                            <label> WindQcontrolModesType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContQIEC}>Save</button>
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

export default UpdateWindContQIECComponent
