import React, { Component } from 'react'
import ExcOEX3TService from '../services/ExcOEX3TService'

class ViewExcOEX3TComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excOEX3T: {}
        }
    }

    componentDidMount(){
        ExcOEX3TService.getExcOEX3TById(this.state.id).then( res => {
            this.setState({excOEX3T: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcOEX3T Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcOEX3TComponent
