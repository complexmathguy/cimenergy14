import React, { Component } from 'react'
import EquivalentBranchService from '../services/EquivalentBranchService'

class ViewEquivalentBranchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equivalentBranch: {}
        }
    }

    componentDidMount(){
        EquivalentBranchService.getEquivalentBranchById(this.state.id).then( res => {
            this.setState({equivalentBranch: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquivalentBranch Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquivalentBranchComponent
