import React, { Component } from 'react'
import ExcST4BService from '../services/ExcST4BService'

class ViewExcST4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST4B: {}
        }
    }

    componentDidMount(){
        ExcST4BService.getExcST4BById(this.state.id).then( res => {
            this.setState({excST4B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST4B Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST4BComponent
