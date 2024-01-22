import React, { Component } from 'react'
import MutualCouplingService from '../services/MutualCouplingService'

class ViewMutualCouplingComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            mutualCoupling: {}
        }
    }

    componentDidMount(){
        MutualCouplingService.getMutualCouplingById(this.state.id).then( res => {
            this.setState({mutualCoupling: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MutualCoupling Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMutualCouplingComponent
