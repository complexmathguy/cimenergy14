import React, { Component } from 'react'
import GovHydro2Service from '../services/GovHydro2Service';

class CreateGovHydro2Component extends Component {
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
            GovHydro2Service.getGovHydro2ById(this.state.id).then( (res) =>{
                let govHydro2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydro2 = (e) => {
        e.preventDefault();
        let govHydro2 = {
                govHydro2Id: this.state.id,
            };
        console.log('govHydro2 => ' + JSON.stringify(govHydro2));

        // step 5
        if(this.state.id === '_add'){
            govHydro2.govHydro2Id=''
            GovHydro2Service.createGovHydro2(govHydro2).then(res =>{
                this.props.history.push('/govHydro2s');
            });
        }else{
            GovHydro2Service.updateGovHydro2(govHydro2).then( res => {
                this.props.history.push('/govHydro2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydro2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydro2</h3>
        }else{
            return <h3 className="text-center">Update GovHydro2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydro2}>Save</button>
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

export default CreateGovHydro2Component
