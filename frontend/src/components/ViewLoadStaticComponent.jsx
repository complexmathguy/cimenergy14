import React, { Component } from 'react'
import LoadStaticService from '../services/LoadStaticService'

class ViewLoadStaticComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadStatic: {}
        }
    }

    componentDidMount(){
        LoadStaticService.getLoadStaticById(this.state.id).then( res => {
            this.setState({loadStatic: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadStatic Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> StaticLoadModelType:&emsp; </label>
                            <div> { this.state.loadStatic.staticLoadModelType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadStaticComponent
