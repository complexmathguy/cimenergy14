import React, { Component } from 'react'
import PerLengthDCLineParameterService from '../services/PerLengthDCLineParameterService';

class UpdatePerLengthDCLineParameterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePerLengthDCLineParameter = this.updatePerLengthDCLineParameter.bind(this);

    }

    componentDidMount(){
        PerLengthDCLineParameterService.getPerLengthDCLineParameterById(this.state.id).then( (res) =>{
            let perLengthDCLineParameter = res.data;
            this.setState({
            });
        });
    }

    updatePerLengthDCLineParameter = (e) => {
        e.preventDefault();
        let perLengthDCLineParameter = {
            perLengthDCLineParameterId: this.state.id,
        };
        console.log('perLengthDCLineParameter => ' + JSON.stringify(perLengthDCLineParameter));
        console.log('id => ' + JSON.stringify(this.state.id));
        PerLengthDCLineParameterService.updatePerLengthDCLineParameter(perLengthDCLineParameter).then( res => {
            this.props.history.push('/perLengthDCLineParameters');
        });
    }


    cancel(){
        this.props.history.push('/perLengthDCLineParameters');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PerLengthDCLineParameter</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePerLengthDCLineParameter}>Save</button>
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

export default UpdatePerLengthDCLineParameterComponent
