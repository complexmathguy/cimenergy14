import React, { Component } from 'react'
import ExcBBCService from '../services/ExcBBCService'

class ViewExcBBCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excBBC: {}
        }
    }

    componentDidMount(){
        ExcBBCService.getExcBBCById(this.state.id).then( res => {
            this.setState({excBBC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcBBC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcBBCComponent
