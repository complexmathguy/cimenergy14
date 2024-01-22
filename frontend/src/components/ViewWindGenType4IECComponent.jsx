import React, { Component } from 'react'
import WindGenType4IECService from '../services/WindGenType4IECService'

class ViewWindGenType4IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windGenType4IEC: {}
        }
    }

    componentDidMount(){
        WindGenType4IECService.getWindGenType4IECById(this.state.id).then( res => {
            this.setState({windGenType4IEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindGenType4IEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindGenType4IECComponent
