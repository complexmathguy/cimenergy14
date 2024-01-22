import React, { Component } from 'react'
import GovGASTService from '../services/GovGASTService'

class ViewGovGASTComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGAST: {}
        }
    }

    componentDidMount(){
        GovGASTService.getGovGASTById(this.state.id).then( res => {
            this.setState({govGAST: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGAST Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGASTComponent
