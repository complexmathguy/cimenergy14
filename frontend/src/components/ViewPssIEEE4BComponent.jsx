import React, { Component } from 'react'
import PssIEEE4BService from '../services/PssIEEE4BService'

class ViewPssIEEE4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssIEEE4B: {}
        }
    }

    componentDidMount(){
        PssIEEE4BService.getPssIEEE4BById(this.state.id).then( res => {
            this.setState({pssIEEE4B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssIEEE4B Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssIEEE4BComponent
