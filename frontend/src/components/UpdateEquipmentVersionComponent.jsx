import React, { Component } from 'react'
import EquipmentVersionService from '../services/EquipmentVersionService';

class UpdateEquipmentVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquipmentVersion = this.updateEquipmentVersion.bind(this);

    }

    componentDidMount(){
        EquipmentVersionService.getEquipmentVersionById(this.state.id).then( (res) =>{
            let equipmentVersion = res.data;
            this.setState({
            });
        });
    }

    updateEquipmentVersion = (e) => {
        e.preventDefault();
        let equipmentVersion = {
            equipmentVersionId: this.state.id,
        };
        console.log('equipmentVersion => ' + JSON.stringify(equipmentVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquipmentVersionService.updateEquipmentVersion(equipmentVersion).then( res => {
            this.props.history.push('/equipmentVersions');
        });
    }


    cancel(){
        this.props.history.push('/equipmentVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquipmentVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquipmentVersion}>Save</button>
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

export default UpdateEquipmentVersionComponent
