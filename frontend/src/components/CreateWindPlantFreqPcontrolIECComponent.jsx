import React, { Component } from 'react'
import WindPlantFreqPcontrolIECService from '../services/WindPlantFreqPcontrolIECService';

class CreateWindPlantFreqPcontrolIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindPlantFreqPcontrolIECService.getWindPlantFreqPcontrolIECById(this.state.id).then( (res) =>{
                let windPlantFreqPcontrolIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindPlantFreqPcontrolIEC = (e) => {
        e.preventDefault();
        let windPlantFreqPcontrolIEC = {
                windPlantFreqPcontrolIECId: this.state.id,
            };
        console.log('windPlantFreqPcontrolIEC => ' + JSON.stringify(windPlantFreqPcontrolIEC));

        // step 5
        if(this.state.id === '_add'){
            windPlantFreqPcontrolIEC.windPlantFreqPcontrolIECId=''
            WindPlantFreqPcontrolIECService.createWindPlantFreqPcontrolIEC(windPlantFreqPcontrolIEC).then(res =>{
                this.props.history.push('/windPlantFreqPcontrolIECs');
            });
        }else{
            WindPlantFreqPcontrolIECService.updateWindPlantFreqPcontrolIEC(windPlantFreqPcontrolIEC).then( res => {
                this.props.history.push('/windPlantFreqPcontrolIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windPlantFreqPcontrolIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindPlantFreqPcontrolIEC</h3>
        }else{
            return <h3 className="text-center">Update WindPlantFreqPcontrolIEC</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindPlantFreqPcontrolIEC}>Save</button>
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

export default CreateWindPlantFreqPcontrolIECComponent
