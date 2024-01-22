import React, { Component } from 'react'
import SynchronousMachineDetailedService from '../services/SynchronousMachineDetailedService';

class CreateSynchronousMachineDetailedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ifdBaseType: ''
        }
        this.changeIfdBaseTypeHandler = this.changeIfdBaseTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SynchronousMachineDetailedService.getSynchronousMachineDetailedById(this.state.id).then( (res) =>{
                let synchronousMachineDetailed = res.data;
                this.setState({
                    ifdBaseType: synchronousMachineDetailed.ifdBaseType
                });
            });
        }        
    }
    saveOrUpdateSynchronousMachineDetailed = (e) => {
        e.preventDefault();
        let synchronousMachineDetailed = {
                synchronousMachineDetailedId: this.state.id,
                ifdBaseType: this.state.ifdBaseType
            };
        console.log('synchronousMachineDetailed => ' + JSON.stringify(synchronousMachineDetailed));

        // step 5
        if(this.state.id === '_add'){
            synchronousMachineDetailed.synchronousMachineDetailedId=''
            SynchronousMachineDetailedService.createSynchronousMachineDetailed(synchronousMachineDetailed).then(res =>{
                this.props.history.push('/synchronousMachineDetaileds');
            });
        }else{
            SynchronousMachineDetailedService.updateSynchronousMachineDetailed(synchronousMachineDetailed).then( res => {
                this.props.history.push('/synchronousMachineDetaileds');
            });
        }
    }
    
    changeIfdBaseTypeHandler= (event) => {
        this.setState({ifdBaseType: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachineDetaileds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SynchronousMachineDetailed</h3>
        }else{
            return <h3 className="text-center">Update SynchronousMachineDetailed</h3>
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
                                            <label> IfdBaseType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSynchronousMachineDetailed}>Save</button>
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

export default CreateSynchronousMachineDetailedComponent
