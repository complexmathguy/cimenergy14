import React, { Component } from 'react'
import OverexcLimIEEEService from '../services/OverexcLimIEEEService'

class ViewOverexcLimIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            overexcLimIEEE: {}
        }
    }

    componentDidMount(){
        OverexcLimIEEEService.getOverexcLimIEEEById(this.state.id).then( res => {
            this.setState({overexcLimIEEE: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OverexcLimIEEE Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOverexcLimIEEEComponent
