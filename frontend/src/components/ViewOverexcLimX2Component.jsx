import React, { Component } from 'react'
import OverexcLimX2Service from '../services/OverexcLimX2Service'

class ViewOverexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            overexcLimX2: {}
        }
    }

    componentDidMount(){
        OverexcLimX2Service.getOverexcLimX2ById(this.state.id).then( res => {
            this.setState({overexcLimX2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OverexcLimX2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOverexcLimX2Component
