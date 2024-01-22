import React, { Component } from 'react'
import DiscExcContIEEEDEC3AService from '../services/DiscExcContIEEEDEC3AService'

class ViewDiscExcContIEEEDEC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            discExcContIEEEDEC3A: {}
        }
    }

    componentDidMount(){
        DiscExcContIEEEDEC3AService.getDiscExcContIEEEDEC3AById(this.state.id).then( res => {
            this.setState({discExcContIEEEDEC3A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiscExcContIEEEDEC3A Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiscExcContIEEEDEC3AComponent
