import React, { Component } from 'react'
import GovGASTWDService from '../services/GovGASTWDService'

class ViewGovGASTWDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govGASTWD: {}
        }
    }

    componentDidMount(){
        GovGASTWDService.getGovGASTWDById(this.state.id).then( res => {
            this.setState({govGASTWD: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovGASTWD Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovGASTWDComponent
