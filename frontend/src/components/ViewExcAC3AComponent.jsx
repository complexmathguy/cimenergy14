import React, { Component } from 'react'
import ExcAC3AService from '../services/ExcAC3AService'

class ViewExcAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC3A: {}
        }
    }

    componentDidMount(){
        ExcAC3AService.getExcAC3AById(this.state.id).then( res => {
            this.setState({excAC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC3A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC3AComponent
