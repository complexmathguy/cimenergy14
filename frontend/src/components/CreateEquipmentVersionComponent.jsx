import React, { Component } from 'react'
import EquipmentVersionService from '../services/EquipmentVersionService';

class CreateEquipmentVersionComponent extends Component {
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
            EquipmentVersionService.getEquipmentVersionById(this.state.id).then( (res) =>{
                let equipmentVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEquipmentVersion = (e) => {
        e.preventDefault();
        let equipmentVersion = {
                equipmentVersionId: this.state.id,
            };
        console.log('equipmentVersion => ' + JSON.stringify(equipmentVersion));

        // step 5
        if(this.state.id === '_add'){
            equipmentVersion.equipmentVersionId=''
            EquipmentVersionService.createEquipmentVersion(equipmentVersion).then(res =>{
                this.props.history.push('/equipmentVersions');
            });
        }else{
            EquipmentVersionService.updateEquipmentVersion(equipmentVersion).then( res => {
                this.props.history.push('/equipmentVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/equipmentVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquipmentVersion</h3>
        }else{
            return <h3 className="text-center">Update EquipmentVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquipmentVersion}>Save</button>
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

export default CreateEquipmentVersionComponent
