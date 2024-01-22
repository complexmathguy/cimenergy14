import React, { Component } from 'react'
import ExcDC3AService from '../services/ExcDC3AService'

class ViewExcDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excDC3A: {}
        }
    }

    componentDidMount(){
        ExcDC3AService.getExcDC3AById(this.state.id).then( res => {
            this.setState({excDC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcDC3A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcDC3AComponent
