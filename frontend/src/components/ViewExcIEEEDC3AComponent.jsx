import React, { Component } from 'react'
import ExcIEEEDC3AService from '../services/ExcIEEEDC3AService'

class ViewExcIEEEDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEDC3A: {}
        }
    }

    componentDidMount(){
        ExcIEEEDC3AService.getExcIEEEDC3AById(this.state.id).then( res => {
            this.setState({excIEEEDC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEDC3A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEDC3AComponent
