import React, { Component } from 'react'
import RotatingMachineDynamicsService from '../services/RotatingMachineDynamicsService';

class CreateRotatingMachineDynamicsComponent extends Component {
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
            RotatingMachineDynamicsService.getRotatingMachineDynamicsById(this.state.id).then( (res) =>{
                let rotatingMachineDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateRotatingMachineDynamics = (e) => {
        e.preventDefault();
        let rotatingMachineDynamics = {
                rotatingMachineDynamicsId: this.state.id,
            };
        console.log('rotatingMachineDynamics => ' + JSON.stringify(rotatingMachineDynamics));

        // step 5
        if(this.state.id === '_add'){
            rotatingMachineDynamics.rotatingMachineDynamicsId=''
            RotatingMachineDynamicsService.createRotatingMachineDynamics(rotatingMachineDynamics).then(res =>{
                this.props.history.push('/rotatingMachineDynamicss');
            });
        }else{
            RotatingMachineDynamicsService.updateRotatingMachineDynamics(rotatingMachineDynamics).then( res => {
                this.props.history.push('/rotatingMachineDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/rotatingMachineDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RotatingMachineDynamics</h3>
        }else{
            return <h3 className="text-center">Update RotatingMachineDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRotatingMachineDynamics}>Save</button>
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

export default CreateRotatingMachineDynamicsComponent
