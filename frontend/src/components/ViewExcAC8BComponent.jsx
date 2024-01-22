import React, { Component } from 'react'
import ExcAC8BService from '../services/ExcAC8BService'

class ViewExcAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excAC8B: {}
        }
    }

    componentDidMount(){
        ExcAC8BService.getExcAC8BById(this.state.id).then( res => {
            this.setState({excAC8B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcAC8B Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcAC8BComponent
