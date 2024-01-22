import React, { Component } from 'react'
import IdentifiedObjectService from '../services/IdentifiedObjectService';

class CreateIdentifiedObjectComponent extends Component {
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
            IdentifiedObjectService.getIdentifiedObjectById(this.state.id).then( (res) =>{
                let identifiedObject = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateIdentifiedObject = (e) => {
        e.preventDefault();
        let identifiedObject = {
                identifiedObjectId: this.state.id,
            };
        console.log('identifiedObject => ' + JSON.stringify(identifiedObject));

        // step 5
        if(this.state.id === '_add'){
            identifiedObject.identifiedObjectId=''
            IdentifiedObjectService.createIdentifiedObject(identifiedObject).then(res =>{
                this.props.history.push('/identifiedObjects');
            });
        }else{
            IdentifiedObjectService.updateIdentifiedObject(identifiedObject).then( res => {
                this.props.history.push('/identifiedObjects');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/identifiedObjects');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add IdentifiedObject</h3>
        }else{
            return <h3 className="text-center">Update IdentifiedObject</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateIdentifiedObject}>Save</button>
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

export default CreateIdentifiedObjectComponent
