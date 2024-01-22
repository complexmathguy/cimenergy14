import React, { Component } from 'react'
import GovGAST2Service from '../services/GovGAST2Service'

class ViewGovGAST2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST2: {}
        }
    }

    componentDidMount(){
        GovGAST2Service.getGovGAST2ById(this.state.id).then( res => {
            this.setState({govGAST2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGAST2Component
