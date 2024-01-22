import React, { Component } from 'react'
import EquipmentBoundaryVersionService from '../services/EquipmentBoundaryVersionService';

class CreateEquipmentBoundaryVersionComponent extends Component {
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
            EquipmentBoundaryVersionService.getEquipmentBoundaryVersionById(this.state.id).then( (res) =>{
                let equipmentBoundaryVersion = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEquipmentBoundaryVersion = (e) => {
        e.preventDefault();
        let equipmentBoundaryVersion = {
                equipmentBoundaryVersionId: this.state.id,
            };
        console.log('equipmentBoundaryVersion => ' + JSON.stringify(equipmentBoundaryVersion));

        // step 5
        if(this.state.id === '_add'){
            equipmentBoundaryVersion.equipmentBoundaryVersionId=''
            EquipmentBoundaryVersionService.createEquipmentBoundaryVersion(equipmentBoundaryVersion).then(res =>{
                this.props.history.push('/equipmentBoundaryVersions');
            });
        }else{
            EquipmentBoundaryVersionService.updateEquipmentBoundaryVersion(equipmentBoundaryVersion).then( res => {
                this.props.history.push('/equipmentBoundaryVersions');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/equipmentBoundaryVersions');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquipmentBoundaryVersion</h3>
        }else{
            return <h3 className="text-center">Update EquipmentBoundaryVersion</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquipmentBoundaryVersion}>Save</button>
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

export default CreateEquipmentBoundaryVersionComponent
