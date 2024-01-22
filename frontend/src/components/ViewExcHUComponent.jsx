import React, { Component } from 'react'
import ExcHUService from '../services/ExcHUService'

class ViewExcHUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excHU: {}
        }
    }

    componentDidMount(){
        ExcHUService.getExcHUById(this.state.id).then( res => {
            this.setState({excHU: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcHU Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcHUComponent
