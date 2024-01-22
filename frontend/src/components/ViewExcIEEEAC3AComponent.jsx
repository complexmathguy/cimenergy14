import React, { Component } from 'react'
import ExcIEEEAC3AService from '../services/ExcIEEEAC3AService'

class ViewExcIEEEAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC3A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC3AService.getExcIEEEAC3AById(this.state.id).then( res => {
            this.setState({excIEEEAC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC3A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC3AComponent
