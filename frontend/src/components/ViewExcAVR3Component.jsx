import React, { Component } from 'react'
import ExcAVR3Service from '../services/ExcAVR3Service'

class ViewExcAVR3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAVR3: {}
        }
    }

    componentDidMount(){
        ExcAVR3Service.getExcAVR3ById(this.state.id).then( res => {
            this.setState({excAVR3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAVR3 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAVR3Component
