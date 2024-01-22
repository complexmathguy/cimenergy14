import React, { Component } from 'react'
import SwitchProxyService from '../services/SwitchProxyService';

class UpdateSwitchProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSwitchProxy = this.updateSwitchProxy.bind(this);

    }

    componentDidMount(){
        SwitchProxyService.getSwitchProxyById(this.state.id).then( (res) =>{
            let switchProxy = res.data;
            this.setState({
            });
        });
    }

    updateSwitchProxy = (e) => {
        e.preventDefault();
        let switchProxy = {
            switchProxyId: this.state.id,
        };
        console.log('switchProxy => ' + JSON.stringify(switchProxy));
        console.log('id => ' + JSON.stringify(this.state.id));
        SwitchProxyService.updateSwitchProxy(switchProxy).then( res => {
            this.props.history.push('/switchProxys');
        });
    }


    cancel(){
        this.props.history.push('/switchProxys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SwitchProxy</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSwitchProxy}>Save</button>
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

export default UpdateSwitchProxyComponent
