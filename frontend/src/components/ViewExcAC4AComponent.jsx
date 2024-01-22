import React, { Component } from 'react'
import ExcAC4AService from '../services/ExcAC4AService'

class ViewExcAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC4A: {}
        }
    }

    componentDidMount(){
        ExcAC4AService.getExcAC4AById(this.state.id).then( res => {
            this.setState({excAC4A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC4A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC4AComponent
