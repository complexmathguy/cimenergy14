import React, { Component } from 'react'
import SeriesCompensatorService from '../services/SeriesCompensatorService';

class CreateSeriesCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SeriesCompensatorService.getSeriesCompensatorById(this.state.id).then( (res) =>{
                let seriesCompensator = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSeriesCompensator = (e) => {
        e.preventDefault();
        let seriesCompensator = {
                seriesCompensatorId: this.state.id,
            };
        console.log('seriesCompensator => ' + JSON.stringify(seriesCompensator));

        // step 5
        if(this.state.id === '_add'){
            seriesCompensator.seriesCompensatorId=''
            SeriesCompensatorService.createSeriesCompensator(seriesCompensator).then(res =>{
                this.props.history.push('/seriesCompensators');
            });
        }else{
            SeriesCompensatorService.updateSeriesCompensator(seriesCompensator).then( res => {
                this.props.history.push('/seriesCompensators');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/seriesCompensators');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SeriesCompensator</h3>
        }else{
            return <h3 className="text-center">Update SeriesCompensator</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSeriesCompensator}>Save</button>
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

export default CreateSeriesCompensatorComponent
