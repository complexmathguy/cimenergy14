import React, { Component } from 'react'
import BoundaryExtensionsService from '../services/BoundaryExtensionsService'

class ViewBoundaryExtensionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            boundaryExtensions: {}
        }
    }

    componentDidMount(){
        BoundaryExtensionsService.getBoundaryExtensionsById(this.state.id).then( res => {
            this.setState({boundaryExtensions: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View BoundaryExtensions Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBoundaryExtensionsComponent
