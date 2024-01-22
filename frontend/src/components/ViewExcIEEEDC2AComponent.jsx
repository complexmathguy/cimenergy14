import React, { Component } from 'react'
import ExcIEEEDC2AService from '../services/ExcIEEEDC2AService'

class ViewExcIEEEDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEDC2A: {}
        }
    }

    componentDidMount(){
        ExcIEEEDC2AService.getExcIEEEDC2AById(this.state.id).then( res => {
            this.setState({excIEEEDC2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEDC2A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEDC2AComponent
