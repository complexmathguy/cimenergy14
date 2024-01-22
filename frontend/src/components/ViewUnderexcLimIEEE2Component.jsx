import React, { Component } from 'react'
import UnderexcLimIEEE2Service from '../services/UnderexcLimIEEE2Service'

class ViewUnderexcLimIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            underexcLimIEEE2: {}
        }
    }

    componentDidMount(){
        UnderexcLimIEEE2Service.getUnderexcLimIEEE2ById(this.state.id).then( res => {
            this.setState({underexcLimIEEE2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View UnderexcLimIEEE2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnderexcLimIEEE2Component
