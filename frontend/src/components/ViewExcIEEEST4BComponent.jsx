import React, { Component } from 'react'
import ExcIEEEST4BService from '../services/ExcIEEEST4BService'

class ViewExcIEEEST4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST4B: {}
        }
    }

    componentDidMount(){
        ExcIEEEST4BService.getExcIEEEST4BById(this.state.id).then( res => {
            this.setState({excIEEEST4B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST4B Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST4BComponent
