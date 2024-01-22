import React, { Component } from 'react'
import GovGAST3Service from '../services/GovGAST3Service'

class ViewGovGAST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST3: {}
        }
    }

    componentDidMount(){
        GovGAST3Service.getGovGAST3ById(this.state.id).then( res => {
            this.setState({govGAST3: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST3 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGAST3Component
