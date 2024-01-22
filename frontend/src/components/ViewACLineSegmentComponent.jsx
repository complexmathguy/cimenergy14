import React, { Component } from 'react'
import ACLineSegmentService from '../services/ACLineSegmentService'

class ViewACLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            aCLineSegment: {}
        }
    }

    componentDidMount(){
        ACLineSegmentService.getACLineSegmentById(this.state.id).then( res => {
            this.setState({aCLineSegment: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ACLineSegment Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewACLineSegmentComponent
