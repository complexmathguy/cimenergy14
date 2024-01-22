import React, { Component } from 'react'
import ExcIEEEAC4AService from '../services/ExcIEEEAC4AService'

class ViewExcIEEEAC4AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC4A: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC4AService.getExcIEEEAC4AById(this.state.id).then( res => {
            this.setState({excIEEEAC4A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC4A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC4AComponent
