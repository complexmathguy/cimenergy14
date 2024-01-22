import React, { Component } from 'react'
import EquivalentInjectionService from '../services/EquivalentInjectionService'

class ViewEquivalentInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            equivalentInjection: {}
        }
    }

    componentDidMount(){
        EquivalentInjectionService.getEquivalentInjectionById(this.state.id).then( res => {
            this.setState({equivalentInjection: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EquivalentInjection Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEquivalentInjectionComponent
