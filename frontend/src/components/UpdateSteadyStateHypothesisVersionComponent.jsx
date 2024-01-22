import React, { Component } from 'react'
import SteadyStateHypothesisVersionService from '../services/SteadyStateHypothesisVersionService';

class UpdateSteadyStateHypothesisVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSteadyStateHypothesisVersion = this.updateSteadyStateHypothesisVersion.bind(this);

    }

    componentDidMount(){
        SteadyStateHypothesisVersionService.getSteadyStateHypothesisVersionById(this.state.id).then( (res) =>{
            let steadyStateHypothesisVersion = res.data;
            this.setState({
            });
        });
    }

    updateSteadyStateHypothesisVersion = (e) => {
        e.preventDefault();
        let steadyStateHypothesisVersion = {
            steadyStateHypothesisVersionId: this.state.id,
        };
        console.log('steadyStateHypothesisVersion => ' + JSON.stringify(steadyStateHypothesisVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        SteadyStateHypothesisVersionService.updateSteadyStateHypothesisVersion(steadyStateHypothesisVersion).then( res => {
            this.props.history.push('/steadyStateHypothesisVersions');
        });
    }


    cancel(){
        this.props.history.push('/steadyStateHypothesisVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SteadyStateHypothesisVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSteadyStateHypothesisVersion}>Save</button>
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

export default UpdateSteadyStateHypothesisVersionComponent
