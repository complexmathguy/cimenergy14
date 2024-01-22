import React, { Component } from 'react'
import TurbLCFB1Service from '../services/TurbLCFB1Service'

class ViewTurbLCFB1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            turbLCFB1: {}
        }
    }

    componentDidMount(){
        TurbLCFB1Service.getTurbLCFB1ById(this.state.id).then( res => {
            this.setState({turbLCFB1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TurbLCFB1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTurbLCFB1Component
