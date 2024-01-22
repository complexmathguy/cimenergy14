import React, { Component } from 'react'
import ExcIEEEDC1AService from '../services/ExcIEEEDC1AService'

class ViewExcIEEEDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEDC1A: {}
        }
    }

    componentDidMount(){
        ExcIEEEDC1AService.getExcIEEEDC1AById(this.state.id).then( res => {
            this.setState({excIEEEDC1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEDC1A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEDC1AComponent
