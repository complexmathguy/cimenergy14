import React, { Component } from 'react'
import ExcAC5AService from '../services/ExcAC5AService'

class ViewExcAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC5A: {}
        }
    }

    componentDidMount(){
        ExcAC5AService.getExcAC5AById(this.state.id).then( res => {
            this.setState({excAC5A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC5A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC5AComponent
