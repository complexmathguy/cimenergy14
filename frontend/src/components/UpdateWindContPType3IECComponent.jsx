import React, { Component } from 'react'
import WindContPType3IECService from '../services/WindContPType3IECService';

class UpdateWindContPType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindContPType3IEC = this.updateWindContPType3IEC.bind(this);

    }

    componentDidMount(){
        WindContPType3IECService.getWindContPType3IECById(this.state.id).then( (res) =>{
            let windContPType3IEC = res.data;
            this.setState({
            });
        });
    }

    updateWindContPType3IEC = (e) => {
        e.preventDefault();
        let windContPType3IEC = {
            windContPType3IECId: this.state.id,
        };
        console.log('windContPType3IEC => ' + JSON.stringify(windContPType3IEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContPType3IECService.updateWindContPType3IEC(windContPType3IEC).then( res => {
            this.props.history.push('/windContPType3IECs');
        });
    }


    cancel(){
        this.props.history.push('/windContPType3IECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContPType3IEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContPType3IEC}>Save</button>
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

export default UpdateWindContPType3IECComponent
