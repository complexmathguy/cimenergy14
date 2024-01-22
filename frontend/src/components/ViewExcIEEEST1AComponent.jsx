import React, { Component } from 'react'
import ExcIEEEST1AService from '../services/ExcIEEEST1AService'

class ViewExcIEEEST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excIEEEST1A: {}
        }
    }

    componentDidMount(){
        ExcIEEEST1AService.getExcIEEEST1AById(this.state.id).then( res => {
            this.setState({excIEEEST1A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcIEEEST1A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Uelin:&emsp; </label>
                            <div> { this.state.excIEEEST1A.uelin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcIEEEST1AComponent
