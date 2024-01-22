import React, { Component } from 'react'
import ExcAC6AService from '../services/ExcAC6AService'

class ViewExcAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC6A: {}
        }
    }

    componentDidMount(){
        ExcAC6AService.getExcAC6AById(this.state.id).then( res => {
            this.setState({excAC6A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC6A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC6AComponent
