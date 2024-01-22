import React, { Component } from 'react'
import AnalogLimitService from '../services/AnalogLimitService';

class UpdateAnalogLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateAnalogLimit = this.updateAnalogLimit.bind(this);

    }

    componentDidMount(){
        AnalogLimitService.getAnalogLimitById(this.state.id).then( (res) =>{
            let analogLimit = res.data;
            this.setState({
            });
        });
    }

    updateAnalogLimit = (e) => {
        e.preventDefault();
        let analogLimit = {
            analogLimitId: this.state.id,
        };
        console.log('analogLimit => ' + JSON.stringify(analogLimit));
        console.log('id => ' + JSON.stringify(this.state.id));
        AnalogLimitService.updateAnalogLimit(analogLimit).then( res => {
            this.props.history.push('/analogLimits');
        });
    }


    cancel(){
        this.props.history.push('/analogLimits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AnalogLimit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAnalogLimit}>Save</button>
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

export default UpdateAnalogLimitComponent
