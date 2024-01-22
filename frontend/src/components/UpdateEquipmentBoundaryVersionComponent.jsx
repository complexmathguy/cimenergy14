import React, { Component } from 'react'
import EquipmentBoundaryVersionService from '../services/EquipmentBoundaryVersionService';

class UpdateEquipmentBoundaryVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquipmentBoundaryVersion = this.updateEquipmentBoundaryVersion.bind(this);

    }

    componentDidMount(){
        EquipmentBoundaryVersionService.getEquipmentBoundaryVersionById(this.state.id).then( (res) =>{
            let equipmentBoundaryVersion = res.data;
            this.setState({
            });
        });
    }

    updateEquipmentBoundaryVersion = (e) => {
        e.preventDefault();
        let equipmentBoundaryVersion = {
            equipmentBoundaryVersionId: this.state.id,
        };
        console.log('equipmentBoundaryVersion => ' + JSON.stringify(equipmentBoundaryVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquipmentBoundaryVersionService.updateEquipmentBoundaryVersion(equipmentBoundaryVersion).then( res => {
            this.props.history.push('/equipmentBoundaryVersions');
        });
    }


    cancel(){
        this.props.history.push('/equipmentBoundaryVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquipmentBoundaryVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquipmentBoundaryVersion}>Save</button>
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

export default UpdateEquipmentBoundaryVersionComponent
