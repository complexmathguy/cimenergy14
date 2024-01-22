import React, { Component } from 'react'
import DomainVersionService from '../services/DomainVersionService'

class ViewDomainVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            domainVersion: {}
        }
    }

    componentDidMount(){
        DomainVersionService.getDomainVersionById(this.state.id).then( res => {
            this.setState({domainVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DomainVersion Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDomainVersionComponent
