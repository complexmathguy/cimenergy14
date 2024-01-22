import React, { Component } from 'react'
import Quality61850Service from '../services/Quality61850Service'

class ViewQuality61850Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            quality61850: {}
        }
    }

    componentDidMount(){
        Quality61850Service.getQuality61850ById(this.state.id).then( res => {
            this.setState({quality61850: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Quality61850 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Source:&emsp; </label>
                            <div> { this.state.quality61850.source }</div>
                        </div>
                        <div className = "row">
                            <label> Validity:&emsp; </label>
                            <div> { this.state.quality61850.validity }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewQuality61850Component
