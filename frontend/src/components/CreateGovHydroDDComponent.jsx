import React, { Component } from 'react'
import GovHydroDDService from '../services/GovHydroDDService';

class CreateGovHydroDDComponent extends Component {
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
            GovHydroDDService.getGovHydroDDById(this.state.id).then( (res) =>{
                let govHydroDD = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroDD = (e) => {
        e.preventDefault();
        let govHydroDD = {
                govHydroDDId: this.state.id,
            };
        console.log('govHydroDD => ' + JSON.stringify(govHydroDD));

        // step 5
        if(this.state.id === '_add'){
            govHydroDD.govHydroDDId=''
            GovHydroDDService.createGovHydroDD(govHydroDD).then(res =>{
                this.props.history.push('/govHydroDDs');
            });
        }else{
            GovHydroDDService.updateGovHydroDD(govHydroDD).then( res => {
                this.props.history.push('/govHydroDDs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroDDs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroDD</h3>
        }else{
            return <h3 className="text-center">Update GovHydroDD</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroDD}>Save</button>
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

export default CreateGovHydroDDComponent
