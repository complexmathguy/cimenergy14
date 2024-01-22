import React, { Component } from 'react'
import ShuntCompensatorService from '../services/ShuntCompensatorService';

class CreateShuntCompensatorComponent extends Component {
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
            ShuntCompensatorService.getShuntCompensatorById(this.state.id).then( (res) =>{
                let shuntCompensator = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateShuntCompensator = (e) => {
        e.preventDefault();
        let shuntCompensator = {
                shuntCompensatorId: this.state.id,
            };
        console.log('shuntCompensator => ' + JSON.stringify(shuntCompensator));

        // step 5
        if(this.state.id === '_add'){
            shuntCompensator.shuntCompensatorId=''
            ShuntCompensatorService.createShuntCompensator(shuntCompensator).then(res =>{
                this.props.history.push('/shuntCompensators');
            });
        }else{
            ShuntCompensatorService.updateShuntCompensator(shuntCompensator).then( res => {
                this.props.history.push('/shuntCompensators');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/shuntCompensators');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ShuntCompensator</h3>
        }else{
            return <h3 className="text-center">Update ShuntCompensator</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateShuntCompensator}>Save</button>
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

export default CreateShuntCompensatorComponent
