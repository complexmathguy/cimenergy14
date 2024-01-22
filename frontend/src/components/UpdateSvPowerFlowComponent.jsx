import React, { Component } from 'react'
import SvPowerFlowService from '../services/SvPowerFlowService';

class UpdateSvPowerFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSvPowerFlow = this.updateSvPowerFlow.bind(this);

    }

    componentDidMount(){
        SvPowerFlowService.getSvPowerFlowById(this.state.id).then( (res) =>{
            let svPowerFlow = res.data;
            this.setState({
            });
        });
    }

    updateSvPowerFlow = (e) => {
        e.preventDefault();
        let svPowerFlow = {
            svPowerFlowId: this.state.id,
        };
        console.log('svPowerFlow => ' + JSON.stringify(svPowerFlow));
        console.log('id => ' + JSON.stringify(this.state.id));
        SvPowerFlowService.updateSvPowerFlow(svPowerFlow).then( res => {
            this.props.history.push('/svPowerFlows');
        });
    }


    cancel(){
        this.props.history.push('/svPowerFlows');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SvPowerFlow</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSvPowerFlow}>Save</button>
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

export default UpdateSvPowerFlowComponent
