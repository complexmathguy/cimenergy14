import React, { Component } from 'react'
import GovSteam2Service from '../services/GovSteam2Service';

class CreateGovSteam2Component extends Component {
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
            GovSteam2Service.getGovSteam2ById(this.state.id).then( (res) =>{
                let govSteam2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteam2 = (e) => {
        e.preventDefault();
        let govSteam2 = {
                govSteam2Id: this.state.id,
            };
        console.log('govSteam2 => ' + JSON.stringify(govSteam2));

        // step 5
        if(this.state.id === '_add'){
            govSteam2.govSteam2Id=''
            GovSteam2Service.createGovSteam2(govSteam2).then(res =>{
                this.props.history.push('/govSteam2s');
            });
        }else{
            GovSteam2Service.updateGovSteam2(govSteam2).then( res => {
                this.props.history.push('/govSteam2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteam2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteam2</h3>
        }else{
            return <h3 className="text-center">Update GovSteam2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteam2}>Save</button>
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

export default CreateGovSteam2Component
