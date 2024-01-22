import React, { Component } from 'react'
import CommandService from '../services/CommandService';

class UpdateCommandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateCommand = this.updateCommand.bind(this);

    }

    componentDidMount(){
        CommandService.getCommandById(this.state.id).then( (res) =>{
            let command = res.data;
            this.setState({
            });
        });
    }

    updateCommand = (e) => {
        e.preventDefault();
        let command = {
            commandId: this.state.id,
        };
        console.log('command => ' + JSON.stringify(command));
        console.log('id => ' + JSON.stringify(this.state.id));
        CommandService.updateCommand(command).then( res => {
            this.props.history.push('/commands');
        });
    }


    cancel(){
        this.props.history.push('/commands');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Command</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateCommand}>Save</button>
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

export default UpdateCommandComponent
