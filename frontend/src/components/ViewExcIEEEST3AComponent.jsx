import React, { Component } from 'react'
import ExcIEEEST3AService from '../services/ExcIEEEST3AService'

class ViewExcIEEEST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST3A: {}
        }
    }

    componentDidMount(){
        ExcIEEEST3AService.getExcIEEEST3AById(this.state.id).then( res => {
            this.setState({excIEEEST3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST3A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST3AComponent
