import React, { Component } from 'react'
import GovHydroPeltonService from '../services/GovHydroPeltonService';

class CreateGovHydroPeltonComponent extends Component {
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
            GovHydroPeltonService.getGovHydroPeltonById(this.state.id).then( (res) =>{
                let govHydroPelton = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroPelton = (e) => {
        e.preventDefault();
        let govHydroPelton = {
                govHydroPeltonId: this.state.id,
            };
        console.log('govHydroPelton => ' + JSON.stringify(govHydroPelton));

        // step 5
        if(this.state.id === '_add'){
            govHydroPelton.govHydroPeltonId=''
            GovHydroPeltonService.createGovHydroPelton(govHydroPelton).then(res =>{
                this.props.history.push('/govHydroPeltons');
            });
        }else{
            GovHydroPeltonService.updateGovHydroPelton(govHydroPelton).then( res => {
                this.props.history.push('/govHydroPeltons');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroPeltons');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroPelton</h3>
        }else{
            return <h3 className="text-center">Update GovHydroPelton</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroPelton}>Save</button>
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

export default CreateGovHydroPeltonComponent
