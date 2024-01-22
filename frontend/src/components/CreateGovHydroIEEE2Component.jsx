import React, { Component } from 'react'
import GovHydroIEEE2Service from '../services/GovHydroIEEE2Service';

class CreateGovHydroIEEE2Component extends Component {
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
            GovHydroIEEE2Service.getGovHydroIEEE2ById(this.state.id).then( (res) =>{
                let govHydroIEEE2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroIEEE2 = (e) => {
        e.preventDefault();
        let govHydroIEEE2 = {
                govHydroIEEE2Id: this.state.id,
            };
        console.log('govHydroIEEE2 => ' + JSON.stringify(govHydroIEEE2));

        // step 5
        if(this.state.id === '_add'){
            govHydroIEEE2.govHydroIEEE2Id=''
            GovHydroIEEE2Service.createGovHydroIEEE2(govHydroIEEE2).then(res =>{
                this.props.history.push('/govHydroIEEE2s');
            });
        }else{
            GovHydroIEEE2Service.updateGovHydroIEEE2(govHydroIEEE2).then( res => {
                this.props.history.push('/govHydroIEEE2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroIEEE2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroIEEE2</h3>
        }else{
            return <h3 className="text-center">Update GovHydroIEEE2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroIEEE2}>Save</button>
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

export default CreateGovHydroIEEE2Component
