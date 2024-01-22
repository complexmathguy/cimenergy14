import React, { Component } from 'react'
import TransformerEndService from '../services/TransformerEndService'

class ViewTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            transformerEnd: {}
        }
    }

    componentDidMount(){
        TransformerEndService.getTransformerEndById(this.state.id).then( res => {
            this.setState({transformerEnd: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TransformerEnd Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTransformerEndComponent
