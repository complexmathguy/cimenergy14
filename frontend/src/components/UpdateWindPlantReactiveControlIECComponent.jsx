import React, { Component } from 'react'
import WindPlantReactiveControlIECService from '../services/WindPlantReactiveControlIECService';

class UpdateWindPlantReactiveControlIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindPlantReactiveControlIEC = this.updateWindPlantReactiveControlIEC.bind(this);

    }

    componentDidMount(){
        WindPlantReactiveControlIECService.getWindPlantReactiveControlIECById(this.state.id).then( (res) =>{
            let windPlantReactiveControlIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindPlantReactiveControlIEC = (e) => {
        e.preventDefault();
        let windPlantReactiveControlIEC = {
            windPlantReactiveControlIECId: this.state.id,
        };
        console.log('windPlantReactiveControlIEC => ' + JSON.stringify(windPlantReactiveControlIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPlantReactiveControlIECService.updateWindPlantReactiveControlIEC(windPlantReactiveControlIEC).then( res => {
            this.props.history.push('/windPlantReactiveControlIECs');
        });
    }


    cancel(){
        this.props.history.push('/windPlantReactiveControlIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPlantReactiveControlIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPlantReactiveControlIEC}>Save</button>
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

export default UpdateWindPlantReactiveControlIECComponent
