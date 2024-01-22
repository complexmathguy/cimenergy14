import React, { Component } from 'react'
import VCompIEEEType1Service from '../services/VCompIEEEType1Service'

class ViewVCompIEEEType1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            vCompIEEEType1: {}
        }
    }

    componentDidMount(){
        VCompIEEEType1Service.getVCompIEEEType1ById(this.state.id).then( res => {
            this.setState({vCompIEEEType1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VCompIEEEType1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVCompIEEEType1Component
