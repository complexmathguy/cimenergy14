import React, { Component } from 'react'
import ExcDC2AService from '../services/ExcDC2AService'

class ViewExcDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excDC2A: {}
        }
    }

    componentDidMount(){
        ExcDC2AService.getExcDC2AById(this.state.id).then( res => {
            this.setState({excDC2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcDC2A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcDC2AComponent
