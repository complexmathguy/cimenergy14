import React, { Component } from 'react'
import TapChangerTablePointService from '../services/TapChangerTablePointService';

class UpdateTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTapChangerTablePoint = this.updateTapChangerTablePoint.bind(this);

    }

    componentDidMount(){
        TapChangerTablePointService.getTapChangerTablePointById(this.state.id).then( (res) =>{
            let tapChangerTablePoint = res.data;
            this.setState({
            });
        });
    }

    updateTapChangerTablePoint = (e) => {
        e.preventDefault();
        let tapChangerTablePoint = {
            tapChangerTablePointId: this.state.id,
        };
        console.log('tapChangerTablePoint => ' + JSON.stringify(tapChangerTablePoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        TapChangerTablePointService.updateTapChangerTablePoint(tapChangerTablePoint).then( res => {
            this.props.history.push('/tapChangerTablePoints');
        });
    }


    cancel(){
        this.props.history.push('/tapChangerTablePoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TapChangerTablePoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTapChangerTablePoint}>Save</button>
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

export default UpdateTapChangerTablePointComponent
