import React, { Component } from 'react'
import GovCT1Service from '../services/GovCT1Service';

class CreateGovCT1Component extends Component {
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
            GovCT1Service.getGovCT1ById(this.state.id).then( (res) =>{
                let govCT1 = res.data;
                this.setState({
                    rselect: govCT1.rselect
                });
            });
        }        
    }
    saveOrUpdateGovCT1 = (e) => {
        e.preventDefault();
        let govCT1 = {
                govCT1Id: this.state.id,
                rselect: this.state.rselect
            };
        console.log('govCT1 => ' + JSON.stringify(govCT1));

        // step 5
        if(this.state.id === '_add'){
            govCT1.govCT1Id=''
            GovCT1Service.createGovCT1(govCT1).then(res =>{
                this.props.history.push('/govCT1s');
            });
        }else{
            GovCT1Service.updateGovCT1(govCT1).then( res => {
                this.props.history.push('/govCT1s');
            });
        }
    }
    
    changeRselectHandler= (event) => {
        this.setState({rselect: event.target.value});
    }

    cancel(){
        this.props.history.push('/govCT1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovCT1</h3>
        }else{
            return <h3 className="text-center">Update GovCT1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovCT1}>Save</button>
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

export default CreateGovCT1Component
