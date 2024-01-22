import React, { Component } from 'react'
import ENTSOEIdentifiedObjectService from '../services/ENTSOEIdentifiedObjectService'

class ViewENTSOEIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            eNTSOEIdentifiedObject: {}
        }
    }

    componentDidMount(){
        ENTSOEIdentifiedObjectService.getENTSOEIdentifiedObjectById(this.state.id).then( res => {
            this.setState({eNTSOEIdentifiedObject: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ENTSOEIdentifiedObject Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewENTSOEIdentifiedObjectComponent
