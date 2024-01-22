import React, { Component } from 'react'
import WindContQIECService from '../services/WindContQIECService';

class CreateWindContQIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                windLVRTQcontrolModesType: '',
                windQcontrolModesType: ''
        }
        this.changeWindLVRTQcontrolModesTypeHandler = this.changeWindLVRTQcontrolModesTypeHandler.bind(this);
        this.changeWindQcontrolModesTypeHandler = this.changeWindQcontrolModesTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindContQIECService.getWindContQIECById(this.state.id).then( (res) =>{
                let windContQIEC = res.data;
                this.setState({
                    windLVRTQcontrolModesType: windContQIEC.windLVRTQcontrolModesType,
                    windQcontrolModesType: windContQIEC.windQcontrolModesType
                });
            });
        }        
    }
    saveOrUpdateWindContQIEC = (e) => {
        e.preventDefault();
        let windContQIEC = {
                windContQIECId: this.state.id,
                windLVRTQcontrolModesType: this.state.windLVRTQcontrolModesType,
                windQcontrolModesType: this.state.windQcontrolModesType
            };
        console.log('windContQIEC => ' + JSON.stringify(windContQIEC));

        // step 5
        if(this.state.id === '_add'){
            windContQIEC.windContQIECId=''
            WindContQIECService.createWindContQIEC(windContQIEC).then(res =>{
                this.props.history.push('/windContQIECs');
            });
        }else{
            WindContQIECService.updateWindContQIEC(windContQIEC).then( res => {
                this.props.history.push('/windContQIECs');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContQIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContQIEC</h3>
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
                                            <label> WindLVRTQcontrolModesType: </label>
                                            #formFields( $attribute, 'create')
                                            <label> WindQcontrolModesType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContQIEC}>Save</button>
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

export default CreateWindContQIECComponent
