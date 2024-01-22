import React, { Component } from 'react'
import UnderexcLimIEEE1Service from '../services/UnderexcLimIEEE1Service'

class ViewUnderexcLimIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            underexcLimIEEE1: {}
        }
    }

    componentDidMount(){
        UnderexcLimIEEE1Service.getUnderexcLimIEEE1ById(this.state.id).then( res => {
            this.setState({underexcLimIEEE1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View UnderexcLimIEEE1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnderexcLimIEEE1Component
