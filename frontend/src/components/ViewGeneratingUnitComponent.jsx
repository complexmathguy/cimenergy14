import React, { Component } from 'react'
import GeneratingUnitService from '../services/GeneratingUnitService'

class ViewGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            generatingUnit: {}
        }
    }

    componentDidMount(){
        GeneratingUnitService.getGeneratingUnitById(this.state.id).then( res => {
            this.setState({generatingUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GeneratingUnit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> GenControlSource:&emsp; </label>
                            <div> { this.state.generatingUnit.genControlSource }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGeneratingUnitComponent
