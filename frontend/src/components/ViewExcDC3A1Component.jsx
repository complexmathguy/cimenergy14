import React, { Component } from 'react'
import ExcDC3A1Service from '../services/ExcDC3A1Service'

class ViewExcDC3A1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excDC3A1: {}
        }
    }

    componentDidMount(){
        ExcDC3A1Service.getExcDC3A1ById(this.state.id).then( res => {
            this.setState({excDC3A1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcDC3A1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcDC3A1Component
