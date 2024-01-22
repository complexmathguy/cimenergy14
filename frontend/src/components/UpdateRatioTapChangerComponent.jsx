import React, { Component } from 'react'
import RatioTapChangerService from '../services/RatioTapChangerService';

class UpdateRatioTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                tculControlMode: ''
        }
        this.updateRatioTapChanger = this.updateRatioTapChanger.bind(this);

        this.changeTculControlModeHandler = this.changeTculControlModeHandler.bind(this);
    }

    componentDidMount(){
        RatioTapChangerService.getRatioTapChangerById(this.state.id).then( (res) =>{
            let ratioTapChanger = res.data;
            this.setState({
                tculControlMode: ratioTapChanger.tculControlMode
            });
        });
    }

    updateRatioTapChanger = (e) => {
        e.preventDefault();
        let ratioTapChanger = {
            ratioTapChangerId: this.state.id,
            tculControlMode: this.state.tculControlMode
        };
        console.log('ratioTapChanger => ' + JSON.stringify(ratioTapChanger));
        console.log('id => ' + JSON.stringify(this.state.id));
        RatioTapChangerService.updateRatioTapChanger(ratioTapChanger).then( res => {
            this.props.history.push('/ratioTapChangers');
        });
    }

    changeTculControlModeHandler= (event) => {
        this.setState({tculControlMode: event.target.value});
    }

    cancel(){
        this.props.history.push('/ratioTapChangers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RatioTapChanger</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> TculControlMode: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRatioTapChanger}>Save</button>
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

export default UpdateRatioTapChangerComponent
