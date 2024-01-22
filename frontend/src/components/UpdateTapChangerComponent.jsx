import React, { Component } from 'react'
import TapChangerService from '../services/TapChangerService';

class UpdateTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTapChanger = this.updateTapChanger.bind(this);

    }

    componentDidMount(){
        TapChangerService.getTapChangerById(this.state.id).then( (res) =>{
            let tapChanger = res.data;
            this.setState({
            });
        });
    }

    updateTapChanger = (e) => {
        e.preventDefault();
        let tapChanger = {
            tapChangerId: this.state.id,
        };
        console.log('tapChanger => ' + JSON.stringify(tapChanger));
        console.log('id => ' + JSON.stringify(this.state.id));
        TapChangerService.updateTapChanger(tapChanger).then( res => {
            this.props.history.push('/tapChangers');
        });
    }


    cancel(){
        this.props.history.push('/tapChangers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TapChanger</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTapChanger}>Save</button>
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

export default UpdateTapChangerComponent
