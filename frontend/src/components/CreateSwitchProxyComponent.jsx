import React, { Component } from 'react'
import SwitchProxyService from '../services/SwitchProxyService';

class CreateSwitchProxyComponent extends Component {
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
            SwitchProxyService.getSwitchProxyById(this.state.id).then( (res) =>{
                let switchProxy = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSwitchProxy = (e) => {
        e.preventDefault();
        let switchProxy = {
                switchProxyId: this.state.id,
            };
        console.log('switchProxy => ' + JSON.stringify(switchProxy));

        // step 5
        if(this.state.id === '_add'){
            switchProxy.switchProxyId=''
            SwitchProxyService.createSwitchProxy(switchProxy).then(res =>{
                this.props.history.push('/switchProxys');
            });
        }else{
            SwitchProxyService.updateSwitchProxy(switchProxy).then( res => {
                this.props.history.push('/switchProxys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/switchProxys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SwitchProxy</h3>
        }else{
            return <h3 className="text-center">Update SwitchProxy</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSwitchProxy}>Save</button>
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

export default CreateSwitchProxyComponent
