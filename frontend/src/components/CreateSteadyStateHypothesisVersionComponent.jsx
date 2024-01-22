import React, { Component } from 'react'
import SteadyStateHypothesisVersionService from '../services/SteadyStateHypothesisVersionService';

class CreateSteadyStateHypothesisVersionComponent extends Component {
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
            SteadyStateHypothesisVersionService.getSteadyStateHypothesisVersionById(this.state.id).then( (res) =>{
                let steadyStateHypothesisVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSteadyStateHypothesisVersion = (e) => {
        e.preventDefault();
        let steadyStateHypothesisVersion = {
                steadyStateHypothesisVersionId: this.state.id,
            };
        console.log('steadyStateHypothesisVersion => ' + JSON.stringify(steadyStateHypothesisVersion));

        // step 5
        if(this.state.id === '_add'){
            steadyStateHypothesisVersion.steadyStateHypothesisVersionId=''
            SteadyStateHypothesisVersionService.createSteadyStateHypothesisVersion(steadyStateHypothesisVersion).then(res =>{
                this.props.history.push('/steadyStateHypothesisVersions');
            });
        }else{
            SteadyStateHypothesisVersionService.updateSteadyStateHypothesisVersion(steadyStateHypothesisVersion).then( res => {
                this.props.history.push('/steadyStateHypothesisVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/steadyStateHypothesisVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SteadyStateHypothesisVersion</h3>
        }else{
            return <h3 className="text-center">Update SteadyStateHypothesisVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSteadyStateHypothesisVersion}>Save</button>
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

export default CreateSteadyStateHypothesisVersionComponent
