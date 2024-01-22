import React, { Component } from 'react'
import ExcST6BService from '../services/ExcST6BService'

class ViewExcST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST6B: {}
        }
    }

    componentDidMount(){
        ExcST6BService.getExcST6BById(this.state.id).then( res => {
            this.setState({excST6B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST6B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Oelin:&emsp; </label>
                            <div> { this.state.excST6B.oelin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST6BComponent
