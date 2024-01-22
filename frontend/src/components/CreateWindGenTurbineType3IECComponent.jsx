import React, { Component } from 'react'
import WindGenTurbineType3IECService from '../services/WindGenTurbineType3IECService';

class CreateWindGenTurbineType3IECComponent extends Component {
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
            WindGenTurbineType3IECService.getWindGenTurbineType3IECById(this.state.id).then( (res) =>{
                let windGenTurbineType3IEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindGenTurbineType3IEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3IEC = {
                windGenTurbineType3IECId: this.state.id,
            };
        console.log('windGenTurbineType3IEC => ' + JSON.stringify(windGenTurbineType3IEC));

        // step 5
        if(this.state.id === '_add'){
            windGenTurbineType3IEC.windGenTurbineType3IECId=''
            WindGenTurbineType3IECService.createWindGenTurbineType3IEC(windGenTurbineType3IEC).then(res =>{
                this.props.history.push('/windGenTurbineType3IECs');
            });
        }else{
            WindGenTurbineType3IECService.updateWindGenTurbineType3IEC(windGenTurbineType3IEC).then( res => {
                this.props.history.push('/windGenTurbineType3IECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windGenTurbineType3IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGenTurbineType3IEC</h3>
        }else{
            return <h3 className="text-center">Update WindGenTurbineType3IEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGenTurbineType3IEC}>Save</button>
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

export default CreateWindGenTurbineType3IECComponent
