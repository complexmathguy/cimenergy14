import React, { Component } from 'react'
import MonthDayIntervalService from '../services/MonthDayIntervalService';

class UpdateMonthDayIntervalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateMonthDayInterval = this.updateMonthDayInterval.bind(this);

    }

    componentDidMount(){
        MonthDayIntervalService.getMonthDayIntervalById(this.state.id).then( (res) =>{
            let monthDayInterval = res.data;
            this.setState({
            });
        });
    }

    updateMonthDayInterval = (e) => {
        e.preventDefault();
        let monthDayInterval = {
            monthDayIntervalId: this.state.id,
        };
        console.log('monthDayInterval => ' + JSON.stringify(monthDayInterval));
        console.log('id => ' + JSON.stringify(this.state.id));
        MonthDayIntervalService.updateMonthDayInterval(monthDayInterval).then( res => {
            this.props.history.push('/monthDayIntervals');
        });
    }


    cancel(){
        this.props.history.push('/monthDayIntervals');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MonthDayInterval</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMonthDayInterval}>Save</button>
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

export default UpdateMonthDayIntervalComponent
