import React, { Component } from 'react'
import ExcIEEEAC6AService from '../services/ExcIEEEAC6AService'

class ViewExcIEEEAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC6A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC6AService.getExcIEEEAC6AById(this.state.id).then( res => {
            this.setState({excIEEEAC6A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC6A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC6AComponent
