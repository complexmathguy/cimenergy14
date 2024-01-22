import React, { Component } from 'react'
import IdentifiedObjectService from '../services/IdentifiedObjectService'

class ViewIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            identifiedObject: {}
        }
    }

    componentDidMount(){
        IdentifiedObjectService.getIdentifiedObjectById(this.state.id).then( res => {
            this.setState({identifiedObject: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View IdentifiedObject Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewIdentifiedObjectComponent
