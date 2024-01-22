import React, { Component } from 'react'
import ConnectivityNodeService from '../services/ConnectivityNodeService';

class CreateConnectivityNodeComponent extends Component {
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
            ConnectivityNodeService.getConnectivityNodeById(this.state.id).then( (res) =>{
                let connectivityNode = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateConnectivityNode = (e) => {
        e.preventDefault();
        let connectivityNode = {
                connectivityNodeId: this.state.id,
            };
        console.log('connectivityNode => ' + JSON.stringify(connectivityNode));

        // step 5
        if(this.state.id === '_add'){
            connectivityNode.connectivityNodeId=''
            ConnectivityNodeService.createConnectivityNode(connectivityNode).then(res =>{
                this.props.history.push('/connectivityNodes');
            });
        }else{
            ConnectivityNodeService.updateConnectivityNode(connectivityNode).then( res => {
                this.props.history.push('/connectivityNodes');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/connectivityNodes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ConnectivityNode</h3>
        }else{
            return <h3 className="text-center">Update ConnectivityNode</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateConnectivityNode}>Save</button>
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

export default CreateConnectivityNodeComponent
