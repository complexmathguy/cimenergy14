import React, { Component } from 'react'
import WindPlantFreqPcontrolIECService from '../services/WindPlantFreqPcontrolIECService';

class UpdateWindPlantFreqPcontrolIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindPlantFreqPcontrolIEC = this.updateWindPlantFreqPcontrolIEC.bind(this);

    }

    componentDidMount(){
        WindPlantFreqPcontrolIECService.getWindPlantFreqPcontrolIECById(this.state.id).then( (res) =>{
            let windPlantFreqPcontrolIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindPlantFreqPcontrolIEC = (e) => {
        e.preventDefault();
        let windPlantFreqPcontrolIEC = {
            windPlantFreqPcontrolIECId: this.state.id,
        };
        console.log('windPlantFreqPcontrolIEC => ' + JSON.stringify(windPlantFreqPcontrolIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPlantFreqPcontrolIECService.updateWindPlantFreqPcontrolIEC(windPlantFreqPcontrolIEC).then( res => {
            this.props.history.push('/windPlantFreqPcontrolIECs');
        });
    }


    cancel(){
        this.props.history.push('/windPlantFreqPcontrolIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPlantFreqPcontrolIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPlantFreqPcontrolIEC}>Save</button>
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

export default UpdateWindPlantFreqPcontrolIECComponent
