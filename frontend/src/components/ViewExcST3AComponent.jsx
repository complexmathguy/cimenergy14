import React, { Component } from 'react'
import ExcST3AService from '../services/ExcST3AService'

class ViewExcST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST3A: {}
        }
    }

    componentDidMount(){
        ExcST3AService.getExcST3AById(this.state.id).then( res => {
            this.setState({excST3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST3A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST3AComponent
