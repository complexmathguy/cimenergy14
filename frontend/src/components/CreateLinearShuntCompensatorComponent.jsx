import React, { Component } from 'react'
import LinearShuntCompensatorService from '../services/LinearShuntCompensatorService';

class CreateLinearShuntCompensatorComponent extends Component {
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
            LinearShuntCompensatorService.getLinearShuntCompensatorById(this.state.id).then( (res) =>{
                let linearShuntCompensator = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLinearShuntCompensator = (e) => {
        e.preventDefault();
        let linearShuntCompensator = {
                linearShuntCompensatorId: this.state.id,
            };
        console.log('linearShuntCompensator => ' + JSON.stringify(linearShuntCompensator));

        // step 5
        if(this.state.id === '_add'){
            linearShuntCompensator.linearShuntCompensatorId=''
            LinearShuntCompensatorService.createLinearShuntCompensator(linearShuntCompensator).then(res =>{
                this.props.history.push('/linearShuntCompensators');
            });
        }else{
            LinearShuntCompensatorService.updateLinearShuntCompensator(linearShuntCompensator).then( res => {
                this.props.history.push('/linearShuntCompensators');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/linearShuntCompensators');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LinearShuntCompensator</h3>
        }else{
            return <h3 className="text-center">Update LinearShuntCompensator</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLinearShuntCompensator}>Save</button>
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

export default CreateLinearShuntCompensatorComponent
