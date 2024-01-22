import React, { Component } from 'react'
import GovHydroPIDService from '../services/GovHydroPIDService';

class CreateGovHydroPIDComponent extends Component {
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
            GovHydroPIDService.getGovHydroPIDById(this.state.id).then( (res) =>{
                let govHydroPID = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroPID = (e) => {
        e.preventDefault();
        let govHydroPID = {
                govHydroPIDId: this.state.id,
            };
        console.log('govHydroPID => ' + JSON.stringify(govHydroPID));

        // step 5
        if(this.state.id === '_add'){
            govHydroPID.govHydroPIDId=''
            GovHydroPIDService.createGovHydroPID(govHydroPID).then(res =>{
                this.props.history.push('/govHydroPIDs');
            });
        }else{
            GovHydroPIDService.updateGovHydroPID(govHydroPID).then( res => {
                this.props.history.push('/govHydroPIDs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroPIDs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroPID</h3>
        }else{
            return <h3 className="text-center">Update GovHydroPID</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroPID}>Save</button>
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

export default CreateGovHydroPIDComponent
