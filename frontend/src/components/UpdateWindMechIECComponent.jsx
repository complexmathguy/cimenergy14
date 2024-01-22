import React, { Component } from 'react'
import WindMechIECService from '../services/WindMechIECService';

class UpdateWindMechIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindMechIEC = this.updateWindMechIEC.bind(this);

    }

    componentDidMount(){
        WindMechIECService.getWindMechIECById(this.state.id).then( (res) =>{
            let windMechIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindMechIEC = (e) => {
        e.preventDefault();
        let windMechIEC = {
            windMechIECId: this.state.id,
        };
        console.log('windMechIEC => ' + JSON.stringify(windMechIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindMechIECService.updateWindMechIEC(windMechIEC).then( res => {
            this.props.history.push('/windMechIECs');
        });
    }


    cancel(){
        this.props.history.push('/windMechIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindMechIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindMechIEC}>Save</button>
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

export default UpdateWindMechIECComponent
