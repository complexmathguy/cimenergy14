import React, { Component } from 'react'
import SynchronousMachineDetailedService from '../services/SynchronousMachineDetailedService';

class UpdateSynchronousMachineDetailedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ifdBaseType: ''
        }
        this.updateSynchronousMachineDetailed = this.updateSynchronousMachineDetailed.bind(this);

        this.changeIfdBaseTypeHandler = this.changeIfdBaseTypeHandler.bind(this);
    }

    componentDidMount(){
        SynchronousMachineDetailedService.getSynchronousMachineDetailedById(this.state.id).then( (res) =>{
            let synchronousMachineDetailed = res.data;
            this.setState({
                ifdBaseType: synchronousMachineDetailed.ifdBaseType
            });
        });
    }

    updateSynchronousMachineDetailed = (e) => {
        e.preventDefault();
        let synchronousMachineDetailed = {
            synchronousMachineDetailedId: this.state.id,
            ifdBaseType: this.state.ifdBaseType
        };
        console.log('synchronousMachineDetailed => ' + JSON.stringify(synchronousMachineDetailed));
        console.log('id => ' + JSON.stringify(this.state.id));
        SynchronousMachineDetailedService.updateSynchronousMachineDetailed(synchronousMachineDetailed).then( res => {
            this.props.history.push('/synchronousMachineDetaileds');
        });
    }

    changeIfdBaseTypeHandler= (event) => {
        this.setState({ifdBaseType: event.target.value});
    }

    cancel(){
        this.props.history.push('/synchronousMachineDetaileds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SynchronousMachineDetailed</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> IfdBaseType: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSynchronousMachineDetailed}>Save</button>
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

export default UpdateSynchronousMachineDetailedComponent
