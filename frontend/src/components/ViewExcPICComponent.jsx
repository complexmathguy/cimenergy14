import React, { Component } from 'react'
import ExcPICService from '../services/ExcPICService'

class ViewExcPICComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excPIC: {}
        }
    }

    componentDidMount(){
        ExcPICService.getExcPICById(this.state.id).then( res => {
            this.setState({excPIC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcPIC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcPICComponent
