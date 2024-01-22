import React, { Component } from 'react'
import PowerTransformerEndService from '../services/PowerTransformerEndService';

class UpdatePowerTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                connectionKind: ''
        }
        this.updatePowerTransformerEnd = this.updatePowerTransformerEnd.bind(this);

        this.changeConnectionKindHandler = this.changeConnectionKindHandler.bind(this);
    }

    componentDidMount(){
        PowerTransformerEndService.getPowerTransformerEndById(this.state.id).then( (res) =>{
            let powerTransformerEnd = res.data;
            this.setState({
                connectionKind: powerTransformerEnd.connectionKind
            });
        });
    }

    updatePowerTransformerEnd = (e) => {
        e.preventDefault();
        let powerTransformerEnd = {
            powerTransformerEndId: this.state.id,
            connectionKind: this.state.connectionKind
        };
        console.log('powerTransformerEnd => ' + JSON.stringify(powerTransformerEnd));
        console.log('id => ' + JSON.stringify(this.state.id));
        PowerTransformerEndService.updatePowerTransformerEnd(powerTransformerEnd).then( res => {
            this.props.history.push('/powerTransformerEnds');
        });
    }

    changeConnectionKindHandler= (event) => {
        this.setState({connectionKind: event.target.value});
    }

    cancel(){
        this.props.history.push('/powerTransformerEnds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PowerTransformerEnd</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ConnectionKind: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePowerTransformerEnd}>Save</button>
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

export default UpdatePowerTransformerEndComponent
