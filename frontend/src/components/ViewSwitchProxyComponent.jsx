import React, { Component } from 'react'
import SwitchProxyService from '../services/SwitchProxyService'

class ViewSwitchProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            switchProxy: {}
        }
    }

    componentDidMount(){
        SwitchProxyService.getSwitchProxyById(this.state.id).then( res => {
            this.setState({switchProxy: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SwitchProxy Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSwitchProxyComponent
