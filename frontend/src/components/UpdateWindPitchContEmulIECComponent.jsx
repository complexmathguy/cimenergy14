import React, { Component } from 'react'
import WindPitchContEmulIECService from '../services/WindPitchContEmulIECService';

class UpdateWindPitchContEmulIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindPitchContEmulIEC = this.updateWindPitchContEmulIEC.bind(this);

    }

    componentDidMount(){
        WindPitchContEmulIECService.getWindPitchContEmulIECById(this.state.id).then( (res) =>{
            let windPitchContEmulIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindPitchContEmulIEC = (e) => {
        e.preventDefault();
        let windPitchContEmulIEC = {
            windPitchContEmulIECId: this.state.id,
        };
        console.log('windPitchContEmulIEC => ' + JSON.stringify(windPitchContEmulIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPitchContEmulIECService.updateWindPitchContEmulIEC(windPitchContEmulIEC).then( res => {
            this.props.history.push('/windPitchContEmulIECs');
        });
    }


    cancel(){
        this.props.history.push('/windPitchContEmulIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPitchContEmulIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPitchContEmulIEC}>Save</button>
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

export default UpdateWindPitchContEmulIECComponent
