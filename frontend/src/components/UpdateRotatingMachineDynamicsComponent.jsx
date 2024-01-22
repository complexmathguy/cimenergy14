import React, { Component } from 'react'
import RotatingMachineDynamicsService from '../services/RotatingMachineDynamicsService';

class UpdateRotatingMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateRotatingMachineDynamics = this.updateRotatingMachineDynamics.bind(this);

    }

    componentDidMount(){
        RotatingMachineDynamicsService.getRotatingMachineDynamicsById(this.state.id).then( (res) =>{
            let rotatingMachineDynamics = res.data;
            this.setState({
            });
        });
    }

    updateRotatingMachineDynamics = (e) => {
        e.preventDefault();
        let rotatingMachineDynamics = {
            rotatingMachineDynamicsId: this.state.id,
        };
        console.log('rotatingMachineDynamics => ' + JSON.stringify(rotatingMachineDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        RotatingMachineDynamicsService.updateRotatingMachineDynamics(rotatingMachineDynamics).then( res => {
            this.props.history.push('/rotatingMachineDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/rotatingMachineDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RotatingMachineDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRotatingMachineDynamics}>Save</button>
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

export default UpdateRotatingMachineDynamicsComponent
