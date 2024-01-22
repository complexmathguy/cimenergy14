import React, { Component } from 'react'
import NonlinearShuntCompensatorPointService from '../services/NonlinearShuntCompensatorPointService';

class CreateNonlinearShuntCompensatorPointComponent extends Component {
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
            NonlinearShuntCompensatorPointService.getNonlinearShuntCompensatorPointById(this.state.id).then( (res) =>{
                let nonlinearShuntCompensatorPoint = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateNonlinearShuntCompensatorPoint = (e) => {
        e.preventDefault();
        let nonlinearShuntCompensatorPoint = {
                nonlinearShuntCompensatorPointId: this.state.id,
            };
        console.log('nonlinearShuntCompensatorPoint => ' + JSON.stringify(nonlinearShuntCompensatorPoint));

        // step 5
        if(this.state.id === '_add'){
            nonlinearShuntCompensatorPoint.nonlinearShuntCompensatorPointId=''
            NonlinearShuntCompensatorPointService.createNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint).then(res =>{
                this.props.history.push('/nonlinearShuntCompensatorPoints');
            });
        }else{
            NonlinearShuntCompensatorPointService.updateNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint).then( res => {
                this.props.history.push('/nonlinearShuntCompensatorPoints');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/nonlinearShuntCompensatorPoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add NonlinearShuntCompensatorPoint</h3>
        }else{
            return <h3 className="text-center">Update NonlinearShuntCompensatorPoint</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateNonlinearShuntCompensatorPoint}>Save</button>
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

export default CreateNonlinearShuntCompensatorPointComponent
