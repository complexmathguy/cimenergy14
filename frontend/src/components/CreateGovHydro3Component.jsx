import React, { Component } from 'react'
import GovHydro3Service from '../services/GovHydro3Service';

class CreateGovHydro3Component extends Component {
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
            GovHydro3Service.getGovHydro3ById(this.state.id).then( (res) =>{
                let govHydro3 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydro3 = (e) => {
        e.preventDefault();
        let govHydro3 = {
                govHydro3Id: this.state.id,
            };
        console.log('govHydro3 => ' + JSON.stringify(govHydro3));

        // step 5
        if(this.state.id === '_add'){
            govHydro3.govHydro3Id=''
            GovHydro3Service.createGovHydro3(govHydro3).then(res =>{
                this.props.history.push('/govHydro3s');
            });
        }else{
            GovHydro3Service.updateGovHydro3(govHydro3).then( res => {
                this.props.history.push('/govHydro3s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydro3s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydro3</h3>
        }else{
            return <h3 className="text-center">Update GovHydro3</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydro3}>Save</button>
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

export default CreateGovHydro3Component
