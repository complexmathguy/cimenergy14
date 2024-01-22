import React, { Component } from 'react'
import ExcAC1AService from '../services/ExcAC1AService'

class ViewExcAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC1A: {}
        }
    }

    componentDidMount(){
        ExcAC1AService.getExcAC1AById(this.state.id).then( res => {
            this.setState({excAC1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC1A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC1AComponent
