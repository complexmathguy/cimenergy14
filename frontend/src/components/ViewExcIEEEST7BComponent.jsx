import React, { Component } from 'react'
import ExcIEEEST7BService from '../services/ExcIEEEST7BService'

class ViewExcIEEEST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST7B: {}
        }
    }

    componentDidMount(){
        ExcIEEEST7BService.getExcIEEEST7BById(this.state.id).then( res => {
            this.setState({excIEEEST7B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST7B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Oelin:&emsp; </label>
                            <div> { this.state.excIEEEST7B.oelin }</div>
                        </div>
                        <div className = "row">
                            <label> Uelin:&emsp; </label>
                            <div> { this.state.excIEEEST7B.uelin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST7BComponent
