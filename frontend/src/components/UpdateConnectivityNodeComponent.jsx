import React, { Component } from 'react'
import ConnectivityNodeService from '../services/ConnectivityNodeService';

class UpdateConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateConnectivityNode = this.updateConnectivityNode.bind(this);

    }

    componentDidMount(){
        ConnectivityNodeService.getConnectivityNodeById(this.state.id).then( (res) =>{
            let connectivityNode = res.data;
            this.setState({
            });
        });
    }

    updateConnectivityNode = (e) => {
        e.preventDefault();
        let connectivityNode = {
            connectivityNodeId: this.state.id,
        };
        console.log('connectivityNode => ' + JSON.stringify(connectivityNode));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConnectivityNodeService.updateConnectivityNode(connectivityNode).then( res => {
            this.props.history.push('/connectivityNodes');
        });
    }


    cancel(){
        this.props.history.push('/connectivityNodes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ConnectivityNode</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConnectivityNode}>Save</button>
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

export default UpdateConnectivityNodeComponent
