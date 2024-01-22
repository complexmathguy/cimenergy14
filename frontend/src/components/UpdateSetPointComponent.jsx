import React, { Component } from 'react'
import SetPointService from '../services/SetPointService';

class UpdateSetPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSetPoint = this.updateSetPoint.bind(this);

    }

    componentDidMount(){
        SetPointService.getSetPointById(this.state.id).then( (res) =>{
            let setPoint = res.data;
            this.setState({
            });
        });
    }

    updateSetPoint = (e) => {
        e.preventDefault();
        let setPoint = {
            setPointId: this.state.id,
        };
        console.log('setPoint => ' + JSON.stringify(setPoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        SetPointService.updateSetPoint(setPoint).then( res => {
            this.props.history.push('/setPoints');
        });
    }


    cancel(){
        this.props.history.push('/setPoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SetPoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSetPoint}>Save</button>
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

export default UpdateSetPointComponent
