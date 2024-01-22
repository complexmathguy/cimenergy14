import React, { Component } from 'react'
import UnderexcitationLimiterUserDefinedService from '../services/UnderexcitationLimiterUserDefinedService';

class UpdateUnderexcitationLimiterUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateUnderexcitationLimiterUserDefined = this.updateUnderexcitationLimiterUserDefined.bind(this);

    }

    componentDidMount(){
        UnderexcitationLimiterUserDefinedService.getUnderexcitationLimiterUserDefinedById(this.state.id).then( (res) =>{
            let underexcitationLimiterUserDefined = res.data;
            this.setState({
            });
        });
    }

    updateUnderexcitationLimiterUserDefined = (e) => {
        e.preventDefault();
        let underexcitationLimiterUserDefined = {
            underexcitationLimiterUserDefinedId: this.state.id,
        };
        console.log('underexcitationLimiterUserDefined => ' + JSON.stringify(underexcitationLimiterUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        UnderexcitationLimiterUserDefinedService.updateUnderexcitationLimiterUserDefined(underexcitationLimiterUserDefined).then( res => {
            this.props.history.push('/underexcitationLimiterUserDefineds');
        });
    }


    cancel(){
        this.props.history.push('/underexcitationLimiterUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update UnderexcitationLimiterUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateUnderexcitationLimiterUserDefined}>Save</button>
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

export default UpdateUnderexcitationLimiterUserDefinedComponent
