import React, { Component } from 'react'
import WindProtectionIECService from '../services/WindProtectionIECService';

class UpdateWindProtectionIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindProtectionIEC = this.updateWindProtectionIEC.bind(this);

    }

    componentDidMount(){
        WindProtectionIECService.getWindProtectionIECById(this.state.id).then( (res) =>{
            let windProtectionIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindProtectionIEC = (e) => {
        e.preventDefault();
        let windProtectionIEC = {
            windProtectionIECId: this.state.id,
        };
        console.log('windProtectionIEC => ' + JSON.stringify(windProtectionIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindProtectionIECService.updateWindProtectionIEC(windProtectionIEC).then( res => {
            this.props.history.push('/windProtectionIECs');
        });
    }


    cancel(){
        this.props.history.push('/windProtectionIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindProtectionIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindProtectionIEC}>Save</button>
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

export default UpdateWindProtectionIECComponent
