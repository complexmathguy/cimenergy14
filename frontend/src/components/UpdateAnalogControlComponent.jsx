import React, { Component } from 'react'
import AnalogControlService from '../services/AnalogControlService';

class UpdateAnalogControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAnalogControl = this.updateAnalogControl.bind(this);

    }

    componentDidMount(){
        AnalogControlService.getAnalogControlById(this.state.id).then( (res) =>{
            let analogControl = res.data;
            this.setState({
            });
        });
    }

    updateAnalogControl = (e) => {
        e.preventDefault();
        let analogControl = {
            analogControlId: this.state.id,
        };
        console.log('analogControl => ' + JSON.stringify(analogControl));
        console.log('id => ' + JSON.stringify(this.state.id));
        AnalogControlService.updateAnalogControl(analogControl).then( res => {
            this.props.history.push('/analogControls');
        });
    }


    cancel(){
        this.props.history.push('/analogControls');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AnalogControl</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAnalogControl}>Save</button>
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

export default UpdateAnalogControlComponent
