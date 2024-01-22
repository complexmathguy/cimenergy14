import React, { Component } from 'react'
import ExcCZService from '../services/ExcCZService'

class ViewExcCZComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excCZ: {}
        }
    }

    componentDidMount(){
        ExcCZService.getExcCZById(this.state.id).then( res => {
            this.setState({excCZ: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcCZ Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcCZComponent
