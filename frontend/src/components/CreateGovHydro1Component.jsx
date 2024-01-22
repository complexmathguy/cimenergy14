import React, { Component } from 'react'
import GovHydro1Service from '../services/GovHydro1Service';

class CreateGovHydro1Component extends Component {
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
            GovHydro1Service.getGovHydro1ById(this.state.id).then( (res) =>{
                let govHydro1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydro1 = (e) => {
        e.preventDefault();
        let govHydro1 = {
                govHydro1Id: this.state.id,
            };
        console.log('govHydro1 => ' + JSON.stringify(govHydro1));

        // step 5
        if(this.state.id === '_add'){
            govHydro1.govHydro1Id=''
            GovHydro1Service.createGovHydro1(govHydro1).then(res =>{
                this.props.history.push('/govHydro1s');
            });
        }else{
            GovHydro1Service.updateGovHydro1(govHydro1).then( res => {
                this.props.history.push('/govHydro1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydro1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydro1</h3>
        }else{
            return <h3 className="text-center">Update GovHydro1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydro1}>Save</button>
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

export default CreateGovHydro1Component
