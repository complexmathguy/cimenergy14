import React, { Component } from 'react'
import LoadGenericNonLinearService from '../services/LoadGenericNonLinearService'

class ViewLoadGenericNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadGenericNonLinear: {}
        }
    }

    componentDidMount(){
        LoadGenericNonLinearService.getLoadGenericNonLinearById(this.state.id).then( res => {
            this.setState({loadGenericNonLinear: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadGenericNonLinear Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> GenericNonLinearLoadModelType:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.genericNonLinearLoadModelType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadGenericNonLinearComponent
