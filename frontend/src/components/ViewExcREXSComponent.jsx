import React, { Component } from 'react'
import ExcREXSService from '../services/ExcREXSService'

class ViewExcREXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excREXS: {}
        }
    }

    componentDidMount(){
        ExcREXSService.getExcREXSById(this.state.id).then( res => {
            this.setState({excREXS: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcREXS Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Fbf:&emsp; </label>
                            <div> { this.state.excREXS.fbf }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcREXSComponent
