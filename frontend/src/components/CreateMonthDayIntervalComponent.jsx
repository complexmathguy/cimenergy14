import React, { Component } from 'react'
import MonthDayIntervalService from '../services/MonthDayIntervalService';

class CreateMonthDayIntervalComponent extends Component {
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
            MonthDayIntervalService.getMonthDayIntervalById(this.state.id).then( (res) =>{
                let monthDayInterval = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateMonthDayInterval = (e) => {
        e.preventDefault();
        let monthDayInterval = {
                monthDayIntervalId: this.state.id,
            };
        console.log('monthDayInterval => ' + JSON.stringify(monthDayInterval));

        // step 5
        if(this.state.id === '_add'){
            monthDayInterval.monthDayIntervalId=''
            MonthDayIntervalService.createMonthDayInterval(monthDayInterval).then(res =>{
                this.props.history.push('/monthDayIntervals');
            });
        }else{
            MonthDayIntervalService.updateMonthDayInterval(monthDayInterval).then( res => {
                this.props.history.push('/monthDayIntervals');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/monthDayIntervals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add MonthDayInterval</h3>
        }else{
            return <h3 className="text-center">Update MonthDayInterval</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateMonthDayInterval}>Save</button>
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

export default CreateMonthDayIntervalComponent
