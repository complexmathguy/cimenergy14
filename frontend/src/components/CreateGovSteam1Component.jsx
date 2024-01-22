import React, { Component } from 'react'
import GovSteam1Service from '../services/GovSteam1Service';

class CreateGovSteam1Component extends Component {
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
            GovSteam1Service.getGovSteam1ById(this.state.id).then( (res) =>{
                let govSteam1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovSteam1 = (e) => {
        e.preventDefault();
        let govSteam1 = {
                govSteam1Id: this.state.id,
            };
        console.log('govSteam1 => ' + JSON.stringify(govSteam1));

        // step 5
        if(this.state.id === '_add'){
            govSteam1.govSteam1Id=''
            GovSteam1Service.createGovSteam1(govSteam1).then(res =>{
                this.props.history.push('/govSteam1s');
            });
        }else{
            GovSteam1Service.updateGovSteam1(govSteam1).then( res => {
                this.props.history.push('/govSteam1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govSteam1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteam1</h3>
        }else{
            return <h3 className="text-center">Update GovSteam1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteam1}>Save</button>
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

export default CreateGovSteam1Component
