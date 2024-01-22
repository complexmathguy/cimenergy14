import React, { Component } from 'react'
import ENTSOEIdentifiedObjectService from '../services/ENTSOEIdentifiedObjectService';

class CreateENTSOEIdentifiedObjectComponent extends Component {
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
            ENTSOEIdentifiedObjectService.getENTSOEIdentifiedObjectById(this.state.id).then( (res) =>{
                let eNTSOEIdentifiedObject = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateENTSOEIdentifiedObject = (e) => {
        e.preventDefault();
        let eNTSOEIdentifiedObject = {
                eNTSOEIdentifiedObjectId: this.state.id,
            };
        console.log('eNTSOEIdentifiedObject => ' + JSON.stringify(eNTSOEIdentifiedObject));

        // step 5
        if(this.state.id === '_add'){
            eNTSOEIdentifiedObject.eNTSOEIdentifiedObjectId=''
            ENTSOEIdentifiedObjectService.createENTSOEIdentifiedObject(eNTSOEIdentifiedObject).then(res =>{
                this.props.history.push('/eNTSOEIdentifiedObjects');
            });
        }else{
            ENTSOEIdentifiedObjectService.updateENTSOEIdentifiedObject(eNTSOEIdentifiedObject).then( res => {
                this.props.history.push('/eNTSOEIdentifiedObjects');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/eNTSOEIdentifiedObjects');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ENTSOEIdentifiedObject</h3>
        }else{
            return <h3 className="text-center">Update ENTSOEIdentifiedObject</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateENTSOEIdentifiedObject}>Save</button>
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

export default CreateENTSOEIdentifiedObjectComponent
