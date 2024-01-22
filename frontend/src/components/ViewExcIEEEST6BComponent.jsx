import React, { Component } from 'react'
import ExcIEEEST6BService from '../services/ExcIEEEST6BService'

class ViewExcIEEEST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST6B: {}
        }
    }

    componentDidMount(){
        ExcIEEEST6BService.getExcIEEEST6BById(this.state.id).then( res => {
            this.setState({excIEEEST6B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST6B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Oelin:&emsp; </label>
                            <div> { this.state.excIEEEST6B.oelin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST6BComponent
