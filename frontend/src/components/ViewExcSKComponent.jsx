import React, { Component } from 'react'
import ExcSKService from '../services/ExcSKService'

class ViewExcSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excSK: {}
        }
    }

    componentDidMount(){
        ExcSKService.getExcSKById(this.state.id).then( res => {
            this.setState({excSK: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcSK Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcSKComponent
