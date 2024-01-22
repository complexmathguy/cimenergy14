import React, { Component } from 'react'
import ExcANSService from '../services/ExcANSService'

class ViewExcANSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excANS: {}
        }
    }

    componentDidMount(){
        ExcANSService.getExcANSById(this.state.id).then( res => {
            this.setState({excANS: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcANS Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcANSComponent
