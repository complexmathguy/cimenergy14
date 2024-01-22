import React, { Component } from 'react'
import ExcELIN1Service from '../services/ExcELIN1Service'

class ViewExcELIN1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excELIN1: {}
        }
    }

    componentDidMount(){
        ExcELIN1Service.getExcELIN1ById(this.state.id).then( res => {
            this.setState({excELIN1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcELIN1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcELIN1Component
