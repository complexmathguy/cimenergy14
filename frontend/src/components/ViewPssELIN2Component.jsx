import React, { Component } from 'react'
import PssELIN2Service from '../services/PssELIN2Service'

class ViewPssELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssELIN2: {}
        }
    }

    componentDidMount(){
        PssELIN2Service.getPssELIN2ById(this.state.id).then( res => {
            this.setState({pssELIN2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssELIN2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssELIN2Component
