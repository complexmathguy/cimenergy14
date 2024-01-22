import React, { Component } from 'react'
import EquipmentVersionService from '../services/EquipmentVersionService'

class ViewEquipmentVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equipmentVersion: {}
        }
    }

    componentDidMount(){
        EquipmentVersionService.getEquipmentVersionById(this.state.id).then( res => {
            this.setState({equipmentVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquipmentVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquipmentVersionComponent
