import React, { Component } from 'react'
import ExcIEEEAC2AService from '../services/ExcIEEEAC2AService'

class ViewExcIEEEAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC2A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC2AService.getExcIEEEAC2AById(this.state.id).then( res => {
            this.setState({excIEEEAC2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC2A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC2AComponent
