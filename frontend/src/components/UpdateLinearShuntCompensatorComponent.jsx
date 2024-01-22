import React, { Component } from 'react'
import LinearShuntCompensatorService from '../services/LinearShuntCompensatorService';

class UpdateLinearShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLinearShuntCompensator = this.updateLinearShuntCompensator.bind(this);

    }

    componentDidMount(){
        LinearShuntCompensatorService.getLinearShuntCompensatorById(this.state.id).then( (res) =>{
            let linearShuntCompensator = res.data;
            this.setState({
            });
        });
    }

    updateLinearShuntCompensator = (e) => {
        e.preventDefault();
        let linearShuntCompensator = {
            linearShuntCompensatorId: this.state.id,
        };
        console.log('linearShuntCompensator => ' + JSON.stringify(linearShuntCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        LinearShuntCompensatorService.updateLinearShuntCompensator(linearShuntCompensator).then( res => {
            this.props.history.push('/linearShuntCompensators');
        });
    }


    cancel(){
        this.props.history.push('/linearShuntCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LinearShuntCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLinearShuntCompensator}>Save</button>
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

export default UpdateLinearShuntCompensatorComponent
