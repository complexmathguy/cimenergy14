import React, { Component } from 'react'
import WindProtectionIECService from '../services/WindProtectionIECService'

class ViewWindProtectionIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windProtectionIEC: {}
        }
    }

    componentDidMount(){
        WindProtectionIECService.getWindProtectionIECById(this.state.id).then( res => {
            this.setState({windProtectionIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindProtectionIEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindProtectionIECComponent
