import React, { Component } from 'react'
import ExcAVR4Service from '../services/ExcAVR4Service'

class ViewExcAVR4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR4: {}
        }
    }

    componentDidMount(){
        ExcAVR4Service.getExcAVR4ById(this.state.id).then( res => {
            this.setState({excAVR4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR4 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR4Component
