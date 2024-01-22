import React, { Component } from 'react'
import EquipmentBoundaryVersionService from '../services/EquipmentBoundaryVersionService'

class ViewEquipmentBoundaryVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equipmentBoundaryVersion: {}
        }
    }

    componentDidMount(){
        EquipmentBoundaryVersionService.getEquipmentBoundaryVersionById(this.state.id).then( res => {
            this.setState({equipmentBoundaryVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquipmentBoundaryVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquipmentBoundaryVersionComponent
