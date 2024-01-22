import React, { Component } from 'react'
import WindContRotorRIECService from '../services/WindContRotorRIECService';

class UpdateWindContRotorRIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindContRotorRIEC = this.updateWindContRotorRIEC.bind(this);

    }

    componentDidMount(){
        WindContRotorRIECService.getWindContRotorRIECById(this.state.id).then( (res) =>{
            let windContRotorRIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindContRotorRIEC = (e) => {
        e.preventDefault();
        let windContRotorRIEC = {
            windContRotorRIECId: this.state.id,
        };
        console.log('windContRotorRIEC => ' + JSON.stringify(windContRotorRIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContRotorRIECService.updateWindContRotorRIEC(windContRotorRIEC).then( res => {
            this.props.history.push('/windContRotorRIECs');
        });
    }


    cancel(){
        this.props.history.push('/windContRotorRIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContRotorRIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContRotorRIEC}>Save</button>
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

export default UpdateWindContRotorRIECComponent
