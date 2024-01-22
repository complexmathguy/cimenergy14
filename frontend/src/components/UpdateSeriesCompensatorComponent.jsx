import React, { Component } from 'react'
import SeriesCompensatorService from '../services/SeriesCompensatorService';

class UpdateSeriesCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSeriesCompensator = this.updateSeriesCompensator.bind(this);

    }

    componentDidMount(){
        SeriesCompensatorService.getSeriesCompensatorById(this.state.id).then( (res) =>{
            let seriesCompensator = res.data;
            this.setState({
            });
        });
    }

    updateSeriesCompensator = (e) => {
        e.preventDefault();
        let seriesCompensator = {
            seriesCompensatorId: this.state.id,
        };
        console.log('seriesCompensator => ' + JSON.stringify(seriesCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        SeriesCompensatorService.updateSeriesCompensator(seriesCompensator).then( res => {
            this.props.history.push('/seriesCompensators');
        });
    }


    cancel(){
        this.props.history.push('/seriesCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SeriesCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSeriesCompensator}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateSeriesCompensatorComponent
