import React, { Component } from 'react'
import TurbineLoadControllerUserDefinedService from '../services/TurbineLoadControllerUserDefinedService';

class UpdateTurbineLoadControllerUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTurbineLoadControllerUserDefined = this.updateTurbineLoadControllerUserDefined.bind(this);

    }

    componentDidMount(){
        TurbineLoadControllerUserDefinedService.getTurbineLoadControllerUserDefinedById(this.state.id).then( (res) =>{
            let turbineLoadControllerUserDefined = res.data;
            this.setState({
            });
        });
    }

    updateTurbineLoadControllerUserDefined = (e) => {
        e.preventDefault();
        let turbineLoadControllerUserDefined = {
            turbineLoadControllerUserDefinedId: this.state.id,
        };
        console.log('turbineLoadControllerUserDefined => ' + JSON.stringify(turbineLoadControllerUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        TurbineLoadControllerUserDefinedService.updateTurbineLoadControllerUserDefined(turbineLoadControllerUserDefined).then( res => {
            this.props.history.push('/turbineLoadControllerUserDefineds');
        });
    }


    cancel(){
        this.props.history.push('/turbineLoadControllerUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TurbineLoadControllerUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTurbineLoadControllerUserDefined}>Save</button>
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

export default UpdateTurbineLoadControllerUserDefinedComponent
