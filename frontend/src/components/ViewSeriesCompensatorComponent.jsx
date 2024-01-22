import React, { Component } from 'react'
import SeriesCompensatorService from '../services/SeriesCompensatorService'

class ViewSeriesCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            seriesCompensator: {}
        }
    }

    componentDidMount(){
        SeriesCompensatorService.getSeriesCompensatorById(this.state.id).then( res => {
            this.setState({seriesCompensator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SeriesCompensator Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSeriesCompensatorComponent
