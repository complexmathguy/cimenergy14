import React, { Component } from 'react'
import SetPointService from '../services/SetPointService'

class ViewSetPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            setPoint: {}
        }
    }

    componentDidMount(){
        SetPointService.getSetPointById(this.state.id).then( res => {
            this.setState({setPoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SetPoint Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSetPointComponent
