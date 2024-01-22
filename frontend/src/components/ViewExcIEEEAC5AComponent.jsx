import React, { Component } from 'react'
import ExcIEEEAC5AService from '../services/ExcIEEEAC5AService'

class ViewExcIEEEAC5AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC5A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC5AService.getExcIEEEAC5AById(this.state.id).then( res => {
            this.setState({excIEEEAC5A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC5A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC5AComponent
