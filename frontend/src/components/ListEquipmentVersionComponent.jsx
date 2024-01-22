import React, { Component } from 'react'
import EquipmentVersionService from '../services/EquipmentVersionService'

class ListEquipmentVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                equipmentVersions: []
        }
        this.addEquipmentVersion = this.addEquipmentVersion.bind(this);
        this.editEquipmentVersion = this.editEquipmentVersion.bind(this);
        this.deleteEquipmentVersion = this.deleteEquipmentVersion.bind(this);
    }

    deleteEquipmentVersion(id){
        EquipmentVersionService.deleteEquipmentVersion(id).then( res => {
            this.setState({equipmentVersions: this.state.equipmentVersions.filter(equipmentVersion => equipmentVersion.equipmentVersionId !== id)});
        });
    }
    viewEquipmentVersion(id){
        this.props.history.push(`/view-equipmentVersion/${id}`);
    }
    editEquipmentVersion(id){
        this.props.history.push(`/add-equipmentVersion/${id}`);
    }

    componentDidMount(){
        EquipmentVersionService.getEquipmentVersions().then((res) => {
            this.setState({ equipmentVersions: res.data});
        });
    }

    addEquipmentVersion(){
        this.props.history.push('/add-equipmentVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">EquipmentVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addEquipmentVersion}> Add EquipmentVersion</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.equipmentVersions.map(
                                        equipmentVersion => 
                                        <tr key = {equipmentVersion.equipmentVersionId}>
                                             <td>
                                                 <button onClick={ () => this.editEquipmentVersion(equipmentVersion.equipmentVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEquipmentVersion(equipmentVersion.equipmentVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewEquipmentVersion(equipmentVersion.equipmentVersionId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListEquipmentVersionComponent
