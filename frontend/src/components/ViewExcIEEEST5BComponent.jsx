import React, { Component } from 'react'
import ExcIEEEST5BService from '../services/ExcIEEEST5BService'

class ViewExcIEEEST5BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST5B: {}
        }
    }

    componentDidMount(){
        ExcIEEEST5BService.getExcIEEEST5BById(this.state.id).then( res => {
            this.setState({excIEEEST5B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST5B Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST5BComponent
