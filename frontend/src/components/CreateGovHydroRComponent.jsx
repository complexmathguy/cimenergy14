import React, { Component } from 'react'
import GovHydroRService from '../services/GovHydroRService';

class CreateGovHydroRComponent extends Component {
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
            GovHydroRService.getGovHydroRById(this.state.id).then( (res) =>{
                let govHydroR = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroR = (e) => {
        e.preventDefault();
        let govHydroR = {
                govHydroRId: this.state.id,
            };
        console.log('govHydroR => ' + JSON.stringify(govHydroR));

        // step 5
        if(this.state.id === '_add'){
            govHydroR.govHydroRId=''
            GovHydroRService.createGovHydroR(govHydroR).then(res =>{
                this.props.history.push('/govHydroRs');
            });
        }else{
            GovHydroRService.updateGovHydroR(govHydroR).then( res => {
                this.props.history.push('/govHydroRs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroRs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroR</h3>
        }else{
            return <h3 className="text-center">Update GovHydroR</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroR}>Save</button>
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

export default CreateGovHydroRComponent
