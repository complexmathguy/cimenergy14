import React, { Component } from 'react'
import ProprietaryParameterDynamicsService from '../services/ProprietaryParameterDynamicsService';

class CreateProprietaryParameterDynamicsComponent extends Component {
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
            ProprietaryParameterDynamicsService.getProprietaryParameterDynamicsById(this.state.id).then( (res) =>{
                let proprietaryParameterDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateProprietaryParameterDynamics = (e) => {
        e.preventDefault();
        let proprietaryParameterDynamics = {
                proprietaryParameterDynamicsId: this.state.id,
            };
        console.log('proprietaryParameterDynamics => ' + JSON.stringify(proprietaryParameterDynamics));

        // step 5
        if(this.state.id === '_add'){
            proprietaryParameterDynamics.proprietaryParameterDynamicsId=''
            ProprietaryParameterDynamicsService.createProprietaryParameterDynamics(proprietaryParameterDynamics).then(res =>{
                this.props.history.push('/proprietaryParameterDynamicss');
            });
        }else{
            ProprietaryParameterDynamicsService.updateProprietaryParameterDynamics(proprietaryParameterDynamics).then( res => {
                this.props.history.push('/proprietaryParameterDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/proprietaryParameterDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ProprietaryParameterDynamics</h3>
        }else{
            return <h3 className="text-center">Update ProprietaryParameterDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateProprietaryParameterDynamics}>Save</button>
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

export default CreateProprietaryParameterDynamicsComponent
