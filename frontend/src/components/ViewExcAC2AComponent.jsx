import React, { Component } from 'react'
import ExcAC2AService from '../services/ExcAC2AService'

class ViewExcAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC2A: {}
        }
    }

    componentDidMount(){
        ExcAC2AService.getExcAC2AById(this.state.id).then( res => {
            this.setState({excAC2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC2A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC2AComponent
