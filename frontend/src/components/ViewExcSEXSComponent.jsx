import React, { Component } from 'react'
import ExcSEXSService from '../services/ExcSEXSService'

class ViewExcSEXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excSEXS: {}
        }
    }

    componentDidMount(){
        ExcSEXSService.getExcSEXSById(this.state.id).then( res => {
            this.setState({excSEXS: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcSEXS Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcSEXSComponent
