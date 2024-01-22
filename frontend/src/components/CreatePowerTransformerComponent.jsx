import React, { Component } from 'react'
import PowerTransformerService from '../services/PowerTransformerService';

class CreatePowerTransformerComponent extends Component {
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
            PowerTransformerService.getPowerTransformerById(this.state.id).then( (res) =>{
                let powerTransformer = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePowerTransformer = (e) => {
        e.preventDefault();
        let powerTransformer = {
                powerTransformerId: this.state.id,
            };
        console.log('powerTransformer => ' + JSON.stringify(powerTransformer));

        // step 5
        if(this.state.id === '_add'){
            powerTransformer.powerTransformerId=''
            PowerTransformerService.createPowerTransformer(powerTransformer).then(res =>{
                this.props.history.push('/powerTransformers');
            });
        }else{
            PowerTransformerService.updatePowerTransformer(powerTransformer).then( res => {
                this.props.history.push('/powerTransformers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/powerTransformers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PowerTransformer</h3>
        }else{
            return <h3 className="text-center">Update PowerTransformer</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePowerTransformer}>Save</button>
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

export default CreatePowerTransformerComponent
