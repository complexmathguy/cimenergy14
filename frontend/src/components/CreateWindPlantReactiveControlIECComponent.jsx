import React, { Component } from 'react'
import WindPlantReactiveControlIECService from '../services/WindPlantReactiveControlIECService';

class CreateWindPlantReactiveControlIECComponent extends Component {
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
            WindPlantReactiveControlIECService.getWindPlantReactiveControlIECById(this.state.id).then( (res) =>{
                let windPlantReactiveControlIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindPlantReactiveControlIEC = (e) => {
        e.preventDefault();
        let windPlantReactiveControlIEC = {
                windPlantReactiveControlIECId: this.state.id,
            };
        console.log('windPlantReactiveControlIEC => ' + JSON.stringify(windPlantReactiveControlIEC));

        // step 5
        if(this.state.id === '_add'){
            windPlantReactiveControlIEC.windPlantReactiveControlIECId=''
            WindPlantReactiveControlIECService.createWindPlantReactiveControlIEC(windPlantReactiveControlIEC).then(res =>{
                this.props.history.push('/windPlantReactiveControlIECs');
            });
        }else{
            WindPlantReactiveControlIECService.updateWindPlantReactiveControlIEC(windPlantReactiveControlIEC).then( res => {
                this.props.history.push('/windPlantReactiveControlIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windPlantReactiveControlIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindPlantReactiveControlIEC</h3>
        }else{
            return <h3 className="text-center">Update WindPlantReactiveControlIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindPlantReactiveControlIEC}>Save</button>
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

export default CreateWindPlantReactiveControlIECComponent
