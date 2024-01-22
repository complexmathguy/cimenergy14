import React, { Component } from 'react'
import WindGenTurbineType3bIECService from '../services/WindGenTurbineType3bIECService';

class CreateWindGenTurbineType3bIECComponent extends Component {
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
            WindGenTurbineType3bIECService.getWindGenTurbineType3bIECById(this.state.id).then( (res) =>{
                let windGenTurbineType3bIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindGenTurbineType3bIEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3bIEC = {
                windGenTurbineType3bIECId: this.state.id,
            };
        console.log('windGenTurbineType3bIEC => ' + JSON.stringify(windGenTurbineType3bIEC));

        // step 5
        if(this.state.id === '_add'){
            windGenTurbineType3bIEC.windGenTurbineType3bIECId=''
            WindGenTurbineType3bIECService.createWindGenTurbineType3bIEC(windGenTurbineType3bIEC).then(res =>{
                this.props.history.push('/windGenTurbineType3bIECs');
            });
        }else{
            WindGenTurbineType3bIECService.updateWindGenTurbineType3bIEC(windGenTurbineType3bIEC).then( res => {
                this.props.history.push('/windGenTurbineType3bIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windGenTurbineType3bIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGenTurbineType3bIEC</h3>
        }else{
            return <h3 className="text-center">Update WindGenTurbineType3bIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGenTurbineType3bIEC}>Save</button>
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

export default CreateWindGenTurbineType3bIECComponent
