import React, { Component } from 'react'
import ACDCTerminalService from '../services/ACDCTerminalService';

class UpdateACDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateACDCTerminal = this.updateACDCTerminal.bind(this);

    }

    componentDidMount(){
        ACDCTerminalService.getACDCTerminalById(this.state.id).then( (res) =>{
            let aCDCTerminal = res.data;
            this.setState({
            });
        });
    }

    updateACDCTerminal = (e) => {
        e.preventDefault();
        let aCDCTerminal = {
            aCDCTerminalId: this.state.id,
        };
        console.log('aCDCTerminal => ' + JSON.stringify(aCDCTerminal));
        console.log('id => ' + JSON.stringify(this.state.id));
        ACDCTerminalService.updateACDCTerminal(aCDCTerminal).then( res => {
            this.props.history.push('/aCDCTerminals');
        });
    }


    cancel(){
        this.props.history.push('/aCDCTerminals');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ACDCTerminal</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateACDCTerminal}>Save</button>
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

export default UpdateACDCTerminalComponent
