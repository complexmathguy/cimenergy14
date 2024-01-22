import React, { Component } from 'react'
import PowerTransformerService from '../services/PowerTransformerService';

class UpdatePowerTransformerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePowerTransformer = this.updatePowerTransformer.bind(this);

    }

    componentDidMount(){
        PowerTransformerService.getPowerTransformerById(this.state.id).then( (res) =>{
            let powerTransformer = res.data;
            this.setState({
            });
        });
    }

    updatePowerTransformer = (e) => {
        e.preventDefault();
        let powerTransformer = {
            powerTransformerId: this.state.id,
        };
        console.log('powerTransformer => ' + JSON.stringify(powerTransformer));
        console.log('id => ' + JSON.stringify(this.state.id));
        PowerTransformerService.updatePowerTransformer(powerTransformer).then( res => {
            this.props.history.push('/powerTransformers');
        });
    }


    cancel(){
        this.props.history.push('/powerTransformers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PowerTransformer</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePowerTransformer}>Save</button>
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

export default UpdatePowerTransformerComponent
