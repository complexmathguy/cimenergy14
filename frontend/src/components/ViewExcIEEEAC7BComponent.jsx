import React, { Component } from 'react'
import ExcIEEEAC7BService from '../services/ExcIEEEAC7BService'

class ViewExcIEEEAC7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC7B: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC7BService.getExcIEEEAC7BById(this.state.id).then( res => {
            this.setState({excIEEEAC7B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC7B Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC7BComponent
