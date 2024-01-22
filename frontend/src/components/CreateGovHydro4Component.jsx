import React, { Component } from 'react'
import GovHydro4Service from '../services/GovHydro4Service';

class CreateGovHydro4Component extends Component {
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
            GovHydro4Service.getGovHydro4ById(this.state.id).then( (res) =>{
                let govHydro4 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydro4 = (e) => {
        e.preventDefault();
        let govHydro4 = {
                govHydro4Id: this.state.id,
            };
        console.log('govHydro4 => ' + JSON.stringify(govHydro4));

        // step 5
        if(this.state.id === '_add'){
            govHydro4.govHydro4Id=''
            GovHydro4Service.createGovHydro4(govHydro4).then(res =>{
                this.props.history.push('/govHydro4s');
            });
        }else{
            GovHydro4Service.updateGovHydro4(govHydro4).then( res => {
                this.props.history.push('/govHydro4s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydro4s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydro4</h3>
        }else{
            return <h3 className="text-center">Update GovHydro4</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydro4}>Save</button>
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

export default CreateGovHydro4Component
