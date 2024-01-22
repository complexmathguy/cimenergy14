import React, { Component } from 'react'
import GovGAST1Service from '../services/GovGAST1Service'

class ViewGovGAST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST1: {}
        }
    }

    componentDidMount(){
        GovGAST1Service.getGovGAST1ById(this.state.id).then( res => {
            this.setState({govGAST1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST1 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGAST1Component
