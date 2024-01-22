import React, { Component } from 'react'
import ExcST1AService from '../services/ExcST1AService'

class ViewExcST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST1A: {}
        }
    }

    componentDidMount(){
        ExcST1AService.getExcST1AById(this.state.id).then( res => {
            this.setState({excST1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST1A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST1AComponent
