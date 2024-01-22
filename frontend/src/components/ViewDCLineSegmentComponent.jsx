import React, { Component } from 'react'
import DCLineSegmentService from '../services/DCLineSegmentService'

class ViewDCLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCLineSegment: {}
        }
    }

    componentDidMount(){
        DCLineSegmentService.getDCLineSegmentById(this.state.id).then( res => {
            this.setState({dCLineSegment: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCLineSegment Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCLineSegmentComponent
