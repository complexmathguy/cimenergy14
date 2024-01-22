import React, { Component } from 'react'
import UnderexcLimX2Service from '../services/UnderexcLimX2Service'

class ViewUnderexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            underexcLimX2: {}
        }
    }

    componentDidMount(){
        UnderexcLimX2Service.getUnderexcLimX2ById(this.state.id).then( res => {
            this.setState({underexcLimX2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View UnderexcLimX2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnderexcLimX2Component
