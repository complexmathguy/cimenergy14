import React, { Component } from 'react'
import PowerTransformerEndService from '../services/PowerTransformerEndService';

class CreatePowerTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                connectionKind: ''
        }
        this.changeConnectionKindHandler = this.changeConnectionKindHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PowerTransformerEndService.getPowerTransformerEndById(this.state.id).then( (res) =>{
                let powerTransformerEnd = res.data;
                this.setState({
                    connectionKind: powerTransformerEnd.connectionKind
                });
            });
        }        
    }
    saveOrUpdatePowerTransformerEnd = (e) => {
        e.preventDefault();
        let powerTransformerEnd = {
                powerTransformerEndId: this.state.id,
                connectionKind: this.state.connectionKind
            };
        console.log('powerTransformerEnd => ' + JSON.stringify(powerTransformerEnd));

        // step 5
        if(this.state.id === '_add'){
            powerTransformerEnd.powerTransformerEndId=''
            PowerTransformerEndService.createPowerTransformerEnd(powerTransformerEnd).then(res =>{
                this.props.history.push('/powerTransformerEnds');
            });
        }else{
            PowerTransformerEndService.updatePowerTransformerEnd(powerTransformerEnd).then( res => {
                this.props.history.push('/powerTransformerEnds');
            });
        }
    }
    
    changeConnectionKindHandler= (event) => {
        this.setState({connectionKind: event.target.value});
    }

    cancel(){
        this.props.history.push('/powerTransformerEnds');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PowerTransformerEnd</h3>
        }else{
            return <h3 className="text-center">Update PowerTransformerEnd</h3>
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
                                            <label> ConnectionKind: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePowerTransformerEnd}>Save</button>
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

export default CreatePowerTransformerEndComponent
