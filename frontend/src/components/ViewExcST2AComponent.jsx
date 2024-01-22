import React, { Component } from 'react'
import ExcST2AService from '../services/ExcST2AService'

class ViewExcST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST2A: {}
        }
    }

    componentDidMount(){
        ExcST2AService.getExcST2AById(this.state.id).then( res => {
            this.setState({excST2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST2A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST2AComponent
