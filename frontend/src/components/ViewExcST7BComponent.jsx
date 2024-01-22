import React, { Component } from 'react'
import ExcST7BService from '../services/ExcST7BService'

class ViewExcST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST7B: {}
        }
    }

    componentDidMount(){
        ExcST7BService.getExcST7BById(this.state.id).then( res => {
            this.setState({excST7B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST7B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Oelin:&emsp; </label>
                            <div> { this.state.excST7B.oelin }</div>
                        </div>
                        <div className = "row">
                            <label> Uelin:&emsp; </label>
                            <div> { this.state.excST7B.uelin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST7BComponent
