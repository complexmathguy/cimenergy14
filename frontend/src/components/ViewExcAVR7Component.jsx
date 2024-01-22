import React, { Component } from 'react'
import ExcAVR7Service from '../services/ExcAVR7Service'

class ViewExcAVR7Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR7: {}
        }
    }

    componentDidMount(){
        ExcAVR7Service.getExcAVR7ById(this.state.id).then( res => {
            this.setState({excAVR7: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR7 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR7Component
