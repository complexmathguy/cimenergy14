import React, { Component } from 'react'
import GovHydroIEEE0Service from '../services/GovHydroIEEE0Service';

class CreateGovHydroIEEE0Component extends Component {
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
            GovHydroIEEE0Service.getGovHydroIEEE0ById(this.state.id).then( (res) =>{
                let govHydroIEEE0 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroIEEE0 = (e) => {
        e.preventDefault();
        let govHydroIEEE0 = {
                govHydroIEEE0Id: this.state.id,
            };
        console.log('govHydroIEEE0 => ' + JSON.stringify(govHydroIEEE0));

        // step 5
        if(this.state.id === '_add'){
            govHydroIEEE0.govHydroIEEE0Id=''
            GovHydroIEEE0Service.createGovHydroIEEE0(govHydroIEEE0).then(res =>{
                this.props.history.push('/govHydroIEEE0s');
            });
        }else{
            GovHydroIEEE0Service.updateGovHydroIEEE0(govHydroIEEE0).then( res => {
                this.props.history.push('/govHydroIEEE0s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroIEEE0s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroIEEE0</h3>
        }else{
            return <h3 className="text-center">Update GovHydroIEEE0</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroIEEE0}>Save</button>
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

export default CreateGovHydroIEEE0Component
