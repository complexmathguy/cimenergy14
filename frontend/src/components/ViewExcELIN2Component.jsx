import React, { Component } from 'react'
import ExcELIN2Service from '../services/ExcELIN2Service'

class ViewExcELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excELIN2: {}
        }
    }

    componentDidMount(){
        ExcELIN2Service.getExcELIN2ById(this.state.id).then( res => {
            this.setState({excELIN2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcELIN2 Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcELIN2Component
