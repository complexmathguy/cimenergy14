import React, { Component } from 'react'
import WindContPitchAngleIECService from '../services/WindContPitchAngleIECService';

class UpdateWindContPitchAngleIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindContPitchAngleIEC = this.updateWindContPitchAngleIEC.bind(this);

    }

    componentDidMount(){
        WindContPitchAngleIECService.getWindContPitchAngleIECById(this.state.id).then( (res) =>{
            let windContPitchAngleIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindContPitchAngleIEC = (e) => {
        e.preventDefault();
        let windContPitchAngleIEC = {
            windContPitchAngleIECId: this.state.id,
        };
        console.log('windContPitchAngleIEC => ' + JSON.stringify(windContPitchAngleIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContPitchAngleIECService.updateWindContPitchAngleIEC(windContPitchAngleIEC).then( res => {
            this.props.history.push('/windContPitchAngleIECs');
        });
    }


    cancel(){
        this.props.history.push('/windContPitchAngleIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContPitchAngleIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContPitchAngleIEC}>Save</button>
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

export default UpdateWindContPitchAngleIECComponent
