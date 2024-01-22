import React, { Component } from 'react'
import AnalogValueService from '../services/AnalogValueService';

class UpdateAnalogValueComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAnalogValue = this.updateAnalogValue.bind(this);

    }

    componentDidMount(){
        AnalogValueService.getAnalogValueById(this.state.id).then( (res) =>{
            let analogValue = res.data;
            this.setState({
            });
        });
    }

    updateAnalogValue = (e) => {
        e.preventDefault();
        let analogValue = {
            analogValueId: this.state.id,
        };
        console.log('analogValue => ' + JSON.stringify(analogValue));
        console.log('id => ' + JSON.stringify(this.state.id));
        AnalogValueService.updateAnalogValue(analogValue).then( res => {
            this.props.history.push('/analogValues');
        });
    }


    cancel(){
        this.props.history.push('/analogValues');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AnalogValue</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAnalogValue}>Save</button>
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

export default UpdateAnalogValueComponent
