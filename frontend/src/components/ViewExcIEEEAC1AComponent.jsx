import React, { Component } from 'react'
import ExcIEEEAC1AService from '../services/ExcIEEEAC1AService'

class ViewExcIEEEAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC1A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC1AService.getExcIEEEAC1AById(this.state.id).then( res => {
            this.setState({excIEEEAC1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC1A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC1AComponent
