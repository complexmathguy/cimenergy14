import React, { Component } from 'react'
import WindContPType4bIECService from '../services/WindContPType4bIECService';

class UpdateWindContPType4bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindContPType4bIEC = this.updateWindContPType4bIEC.bind(this);

    }

    componentDidMount(){
        WindContPType4bIECService.getWindContPType4bIECById(this.state.id).then( (res) =>{
            let windContPType4bIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindContPType4bIEC = (e) => {
        e.preventDefault();
        let windContPType4bIEC = {
            windContPType4bIECId: this.state.id,
        };
        console.log('windContPType4bIEC => ' + JSON.stringify(windContPType4bIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContPType4bIECService.updateWindContPType4bIEC(windContPType4bIEC).then( res => {
            this.props.history.push('/windContPType4bIECs');
        });
    }


    cancel(){
        this.props.history.push('/windContPType4bIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContPType4bIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContPType4bIEC}>Save</button>
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

export default UpdateWindContPType4bIECComponent
