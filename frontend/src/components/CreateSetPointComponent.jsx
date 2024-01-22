import React, { Component } from 'react'
import SetPointService from '../services/SetPointService';

class CreateSetPointComponent extends Component {
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
            SetPointService.getSetPointById(this.state.id).then( (res) =>{
                let setPoint = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSetPoint = (e) => {
        e.preventDefault();
        let setPoint = {
                setPointId: this.state.id,
            };
        console.log('setPoint => ' + JSON.stringify(setPoint));

        // step 5
        if(this.state.id === '_add'){
            setPoint.setPointId=''
            SetPointService.createSetPoint(setPoint).then(res =>{
                this.props.history.push('/setPoints');
            });
        }else{
            SetPointService.updateSetPoint(setPoint).then( res => {
                this.props.history.push('/setPoints');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/setPoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SetPoint</h3>
        }else{
            return <h3 className="text-center">Update SetPoint</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSetPoint}>Save</button>
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

export default CreateSetPointComponent
