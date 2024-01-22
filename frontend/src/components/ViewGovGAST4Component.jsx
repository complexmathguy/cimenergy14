import React, { Component } from 'react'
import GovGAST4Service from '../services/GovGAST4Service'

class ViewGovGAST4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST4: {}
        }
    }

    componentDidMount(){
        GovGAST4Service.getGovGAST4ById(this.state.id).then( res => {
            this.setState({govGAST4: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST4 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGAST4Component
