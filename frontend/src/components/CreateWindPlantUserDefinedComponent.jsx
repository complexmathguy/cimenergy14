import React, { Component } from 'react'
import WindPlantUserDefinedService from '../services/WindPlantUserDefinedService';

class CreateWindPlantUserDefinedComponent extends Component {
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
            WindPlantUserDefinedService.getWindPlantUserDefinedById(this.state.id).then( (res) =>{
                let windPlantUserDefined = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindPlantUserDefined = (e) => {
        e.preventDefault();
        let windPlantUserDefined = {
                windPlantUserDefinedId: this.state.id,
            };
        console.log('windPlantUserDefined => ' + JSON.stringify(windPlantUserDefined));

        // step 5
        if(this.state.id === '_add'){
            windPlantUserDefined.windPlantUserDefinedId=''
            WindPlantUserDefinedService.createWindPlantUserDefined(windPlantUserDefined).then(res =>{
                this.props.history.push('/windPlantUserDefineds');
            });
        }else{
            WindPlantUserDefinedService.updateWindPlantUserDefined(windPlantUserDefined).then( res => {
                this.props.history.push('/windPlantUserDefineds');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windPlantUserDefineds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindPlantUserDefined</h3>
        }else{
            return <h3 className="text-center">Update WindPlantUserDefined</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindPlantUserDefined}>Save</button>
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

export default CreateWindPlantUserDefinedComponent
