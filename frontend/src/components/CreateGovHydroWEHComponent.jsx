import React, { Component } from 'react'
import GovHydroWEHService from '../services/GovHydroWEHService';

class CreateGovHydroWEHComponent extends Component {
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
            GovHydroWEHService.getGovHydroWEHById(this.state.id).then( (res) =>{
                let govHydroWEH = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroWEH = (e) => {
        e.preventDefault();
        let govHydroWEH = {
                govHydroWEHId: this.state.id,
            };
        console.log('govHydroWEH => ' + JSON.stringify(govHydroWEH));

        // step 5
        if(this.state.id === '_add'){
            govHydroWEH.govHydroWEHId=''
            GovHydroWEHService.createGovHydroWEH(govHydroWEH).then(res =>{
                this.props.history.push('/govHydroWEHs');
            });
        }else{
            GovHydroWEHService.updateGovHydroWEH(govHydroWEH).then( res => {
                this.props.history.push('/govHydroWEHs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroWEHs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroWEH</h3>
        }else{
            return <h3 className="text-center">Update GovHydroWEH</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroWEH}>Save</button>
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

export default CreateGovHydroWEHComponent
