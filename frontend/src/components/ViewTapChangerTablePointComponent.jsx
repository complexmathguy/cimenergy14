import React, { Component } from 'react'
import TapChangerTablePointService from '../services/TapChangerTablePointService'

class ViewTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            tapChangerTablePoint: {}
        }
    }

    componentDidMount(){
        TapChangerTablePointService.getTapChangerTablePointById(this.state.id).then( res => {
            this.setState({tapChangerTablePoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TapChangerTablePoint Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTapChangerTablePointComponent
