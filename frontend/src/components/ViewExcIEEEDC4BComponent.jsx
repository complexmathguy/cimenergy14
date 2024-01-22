import React, { Component } from 'react'
import ExcIEEEDC4BService from '../services/ExcIEEEDC4BService'

class ViewExcIEEEDC4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEDC4B: {}
        }
    }

    componentDidMount(){
        ExcIEEEDC4BService.getExcIEEEDC4BById(this.state.id).then( res => {
            this.setState({excIEEEDC4B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEDC4B Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEDC4BComponent
