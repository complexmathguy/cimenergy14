import React, { Component } from 'react'
import NonlinearShuntCompensatorPointService from '../services/NonlinearShuntCompensatorPointService';

class UpdateNonlinearShuntCompensatorPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateNonlinearShuntCompensatorPoint = this.updateNonlinearShuntCompensatorPoint.bind(this);

    }

    componentDidMount(){
        NonlinearShuntCompensatorPointService.getNonlinearShuntCompensatorPointById(this.state.id).then( (res) =>{
            let nonlinearShuntCompensatorPoint = res.data;
            this.setState({
            });
        });
    }

    updateNonlinearShuntCompensatorPoint = (e) => {
        e.preventDefault();
        let nonlinearShuntCompensatorPoint = {
            nonlinearShuntCompensatorPointId: this.state.id,
        };
        console.log('nonlinearShuntCompensatorPoint => ' + JSON.stringify(nonlinearShuntCompensatorPoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        NonlinearShuntCompensatorPointService.updateNonlinearShuntCompensatorPoint(nonlinearShuntCompensatorPoint).then( res => {
            this.props.history.push('/nonlinearShuntCompensatorPoints');
        });
    }


    cancel(){
        this.props.history.push('/nonlinearShuntCompensatorPoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update NonlinearShuntCompensatorPoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateNonlinearShuntCompensatorPoint}>Save</button>
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

export default UpdateNonlinearShuntCompensatorPointComponent
