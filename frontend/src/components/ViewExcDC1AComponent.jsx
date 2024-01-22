import React, { Component } from 'react'
import ExcDC1AService from '../services/ExcDC1AService'

class ViewExcDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excDC1A: {}
        }
    }

    componentDidMount(){
        ExcDC1AService.getExcDC1AById(this.state.id).then( res => {
            this.setState({excDC1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcDC1A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcDC1AComponent
