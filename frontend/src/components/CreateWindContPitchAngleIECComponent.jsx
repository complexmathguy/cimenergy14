import React, { Component } from 'react'
import WindContPitchAngleIECService from '../services/WindContPitchAngleIECService';

class CreateWindContPitchAngleIECComponent extends Component {
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
            WindContPitchAngleIECService.getWindContPitchAngleIECById(this.state.id).then( (res) =>{
                let windContPitchAngleIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindContPitchAngleIEC = (e) => {
        e.preventDefault();
        let windContPitchAngleIEC = {
                windContPitchAngleIECId: this.state.id,
            };
        console.log('windContPitchAngleIEC => ' + JSON.stringify(windContPitchAngleIEC));

        // step 5
        if(this.state.id === '_add'){
            windContPitchAngleIEC.windContPitchAngleIECId=''
            WindContPitchAngleIECService.createWindContPitchAngleIEC(windContPitchAngleIEC).then(res =>{
                this.props.history.push('/windContPitchAngleIECs');
            });
        }else{
            WindContPitchAngleIECService.updateWindContPitchAngleIEC(windContPitchAngleIEC).then( res => {
                this.props.history.push('/windContPitchAngleIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windContPitchAngleIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContPitchAngleIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContPitchAngleIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContPitchAngleIEC}>Save</button>
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

export default CreateWindContPitchAngleIECComponent
