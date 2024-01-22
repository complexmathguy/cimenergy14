import React, { Component } from 'react'
import DynamicsVersionService from '../services/DynamicsVersionService';

class CreateDynamicsVersionComponent extends Component {
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
            DynamicsVersionService.getDynamicsVersionById(this.state.id).then( (res) =>{
                let dynamicsVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDynamicsVersion = (e) => {
        e.preventDefault();
        let dynamicsVersion = {
                dynamicsVersionId: this.state.id,
            };
        console.log('dynamicsVersion => ' + JSON.stringify(dynamicsVersion));

        // step 5
        if(this.state.id === '_add'){
            dynamicsVersion.dynamicsVersionId=''
            DynamicsVersionService.createDynamicsVersion(dynamicsVersion).then(res =>{
                this.props.history.push('/dynamicsVersions');
            });
        }else{
            DynamicsVersionService.updateDynamicsVersion(dynamicsVersion).then( res => {
                this.props.history.push('/dynamicsVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dynamicsVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DynamicsVersion</h3>
        }else{
            return <h3 className="text-center">Update DynamicsVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDynamicsVersion}>Save</button>
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

export default CreateDynamicsVersionComponent
