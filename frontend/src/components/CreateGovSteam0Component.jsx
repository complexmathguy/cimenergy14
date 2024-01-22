import React, { Component } from 'react'
import GovSteam0Service from '../services/GovSteam0Service';

class CreateGovSteam0Component extends Component {
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
            GovSteam0Service.getGovSteam0ById(this.state.id).then( (res) =>{
                let govSteam0 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteam0 = (e) => {
        e.preventDefault();
        let govSteam0 = {
                govSteam0Id: this.state.id,
            };
        console.log('govSteam0 => ' + JSON.stringify(govSteam0));

        // step 5
        if(this.state.id === '_add'){
            govSteam0.govSteam0Id=''
            GovSteam0Service.createGovSteam0(govSteam0).then(res =>{
                this.props.history.push('/govSteam0s');
            });
        }else{
            GovSteam0Service.updateGovSteam0(govSteam0).then( res => {
                this.props.history.push('/govSteam0s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteam0s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteam0</h3>
        }else{
            return <h3 className="text-center">Update GovSteam0</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteam0}>Save</button>
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

export default CreateGovSteam0Component
