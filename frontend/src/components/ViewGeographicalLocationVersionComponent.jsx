import React, { Component } from 'react'
import GeographicalLocationVersionService from '../services/GeographicalLocationVersionService'

class ViewGeographicalLocationVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            geographicalLocationVersion: {}
        }
    }

    componentDidMount(){
        GeographicalLocationVersionService.getGeographicalLocationVersionById(this.state.id).then( res => {
            this.setState({geographicalLocationVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GeographicalLocationVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGeographicalLocationVersionComponent
