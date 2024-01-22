import React, { Component } from 'react'
import BaseVoltageService from '../services/BaseVoltageService';

class UpdateBaseVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateBaseVoltage = this.updateBaseVoltage.bind(this);

    }

    componentDidMount(){
        BaseVoltageService.getBaseVoltageById(this.state.id).then( (res) =>{
            let baseVoltage = res.data;
            this.setState({
            });
        });
    }

    updateBaseVoltage = (e) => {
        e.preventDefault();
        let baseVoltage = {
            baseVoltageId: this.state.id,
        };
        console.log('baseVoltage => ' + JSON.stringify(baseVoltage));
        console.log('id => ' + JSON.stringify(this.state.id));
        BaseVoltageService.updateBaseVoltage(baseVoltage).then( res => {
            this.props.history.push('/baseVoltages');
        });
    }


    cancel(){
        this.props.history.push('/baseVoltages');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update BaseVoltage</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateBaseVoltage}>Save</button>
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

export default UpdateBaseVoltageComponent
