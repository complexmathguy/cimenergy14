import React, { Component } from 'react'
import ExcAVR1Service from '../services/ExcAVR1Service'

class ViewExcAVR1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR1: {}
        }
    }

    componentDidMount(){
        ExcAVR1Service.getExcAVR1ById(this.state.id).then( res => {
            this.setState({excAVR1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR1Component
