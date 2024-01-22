import React, { Component } from 'react'
import WindAeroLinearIECService from '../services/WindAeroLinearIECService';

class UpdateWindAeroLinearIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindAeroLinearIEC = this.updateWindAeroLinearIEC.bind(this);

    }

    componentDidMount(){
        WindAeroLinearIECService.getWindAeroLinearIECById(this.state.id).then( (res) =>{
            let windAeroLinearIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindAeroLinearIEC = (e) => {
        e.preventDefault();
        let windAeroLinearIEC = {
            windAeroLinearIECId: this.state.id,
        };
        console.log('windAeroLinearIEC => ' + JSON.stringify(windAeroLinearIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindAeroLinearIECService.updateWindAeroLinearIEC(windAeroLinearIEC).then( res => {
            this.props.history.push('/windAeroLinearIECs');
        });
    }


    cancel(){
        this.props.history.push('/windAeroLinearIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindAeroLinearIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindAeroLinearIEC}>Save</button>
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

export default UpdateWindAeroLinearIECComponent
