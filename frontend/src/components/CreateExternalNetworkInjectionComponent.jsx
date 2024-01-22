import React, { Component } from 'react'
import ExternalNetworkInjectionService from '../services/ExternalNetworkInjectionService';

class CreateExternalNetworkInjectionComponent extends Component {
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
            ExternalNetworkInjectionService.getExternalNetworkInjectionById(this.state.id).then( (res) =>{
                let externalNetworkInjection = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExternalNetworkInjection = (e) => {
        e.preventDefault();
        let externalNetworkInjection = {
                externalNetworkInjectionId: this.state.id,
            };
        console.log('externalNetworkInjection => ' + JSON.stringify(externalNetworkInjection));

        // step 5
        if(this.state.id === '_add'){
            externalNetworkInjection.externalNetworkInjectionId=''
            ExternalNetworkInjectionService.createExternalNetworkInjection(externalNetworkInjection).then(res =>{
                this.props.history.push('/externalNetworkInjections');
            });
        }else{
            ExternalNetworkInjectionService.updateExternalNetworkInjection(externalNetworkInjection).then( res => {
                this.props.history.push('/externalNetworkInjections');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/externalNetworkInjections');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExternalNetworkInjection</h3>
        }else{
            return <h3 className="text-center">Update ExternalNetworkInjection</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExternalNetworkInjection}>Save</button>
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

export default CreateExternalNetworkInjectionComponent
