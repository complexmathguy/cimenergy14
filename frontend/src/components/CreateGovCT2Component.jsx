import React, { Component } from 'react'
import GovCT2Service from '../services/GovCT2Service';

class CreateGovCT2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                rselect: ''
        }
        this.changeRselectHandler = this.changeRselectHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovCT2Service.getGovCT2ById(this.state.id).then( (res) =>{
                let govCT2 = res.data;
                this.setState({
                    rselect: govCT2.rselect
                });
            });
        }        
    }
    saveOrUpdateGovCT2 = (e) => {
        e.preventDefault();
        let govCT2 = {
                govCT2Id: this.state.id,
                rselect: this.state.rselect
            };
        console.log('govCT2 => ' + JSON.stringify(govCT2));

        // step 5
        if(this.state.id === '_add'){
            govCT2.govCT2Id=''
            GovCT2Service.createGovCT2(govCT2).then(res =>{
                this.props.history.push('/govCT2s');
            });
        }else{
            GovCT2Service.updateGovCT2(govCT2).then( res => {
                this.props.history.push('/govCT2s');
            });
        }
    }
    
    changeRselectHandler= (event) => {
        this.setState({rselect: event.target.value});
    }

    cancel(){
        this.props.history.push('/govCT2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovCT2</h3>
        }else{
            return <h3 className="text-center">Update GovCT2</h3>
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
                                            <label> Rselect: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovCT2}>Save</button>
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

export default CreateGovCT2Component
