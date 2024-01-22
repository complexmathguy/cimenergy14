import React, { Component } from 'react'
import GovHydroPID2Service from '../services/GovHydroPID2Service';

class CreateGovHydroPID2Component extends Component {
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
            GovHydroPID2Service.getGovHydroPID2ById(this.state.id).then( (res) =>{
                let govHydroPID2 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateGovHydroPID2 = (e) => {
        e.preventDefault();
        let govHydroPID2 = {
                govHydroPID2Id: this.state.id,
            };
        console.log('govHydroPID2 => ' + JSON.stringify(govHydroPID2));

        // step 5
        if(this.state.id === '_add'){
            govHydroPID2.govHydroPID2Id=''
            GovHydroPID2Service.createGovHydroPID2(govHydroPID2).then(res =>{
                this.props.history.push('/govHydroPID2s');
            });
        }else{
            GovHydroPID2Service.updateGovHydroPID2(govHydroPID2).then( res => {
                this.props.history.push('/govHydroPID2s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/govHydroPID2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroPID2</h3>
        }else{
            return <h3 className="text-center">Update GovHydroPID2</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroPID2}>Save</button>
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

export default CreateGovHydroPID2Component
