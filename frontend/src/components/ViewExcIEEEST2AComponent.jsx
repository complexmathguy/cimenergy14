import React, { Component } from 'react'
import ExcIEEEST2AService from '../services/ExcIEEEST2AService'

class ViewExcIEEEST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST2A: {}
        }
    }

    componentDidMount(){
        ExcIEEEST2AService.getExcIEEEST2AById(this.state.id).then( res => {
            this.setState({excIEEEST2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST2A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST2AComponent
