import React, { Component } from 'react'
import ShuntCompensatorService from '../services/ShuntCompensatorService';

class UpdateShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateShuntCompensator = this.updateShuntCompensator.bind(this);

    }

    componentDidMount(){
        ShuntCompensatorService.getShuntCompensatorById(this.state.id).then( (res) =>{
            let shuntCompensator = res.data;
            this.setState({
            });
        });
    }

    updateShuntCompensator = (e) => {
        e.preventDefault();
        let shuntCompensator = {
            shuntCompensatorId: this.state.id,
        };
        console.log('shuntCompensator => ' + JSON.stringify(shuntCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        ShuntCompensatorService.updateShuntCompensator(shuntCompensator).then( res => {
            this.props.history.push('/shuntCompensators');
        });
    }


    cancel(){
        this.props.history.push('/shuntCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ShuntCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateShuntCompensator}>Save</button>
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

export default UpdateShuntCompensatorComponent
