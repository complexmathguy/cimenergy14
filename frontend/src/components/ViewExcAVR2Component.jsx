import React, { Component } from 'react'
import ExcAVR2Service from '../services/ExcAVR2Service'

class ViewExcAVR2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR2: {}
        }
    }

    componentDidMount(){
        ExcAVR2Service.getExcAVR2ById(this.state.id).then( res => {
            this.setState({excAVR2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR2Component
