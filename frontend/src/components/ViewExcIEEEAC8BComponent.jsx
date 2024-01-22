import React, { Component } from 'react'
import ExcIEEEAC8BService from '../services/ExcIEEEAC8BService'

class ViewExcIEEEAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEAC8B: {}
        }
    }

    componentDidMount(){
        ExcIEEEAC8BService.getExcIEEEAC8BById(this.state.id).then( res => {
            this.setState({excIEEEAC8B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEAC8B Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEAC8BComponent
