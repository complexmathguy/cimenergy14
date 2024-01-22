import React, { Component } from 'react'
import WindGenTurbineType3aIECService from '../services/WindGenTurbineType3aIECService';

class UpdateWindGenTurbineType3aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindGenTurbineType3aIEC = this.updateWindGenTurbineType3aIEC.bind(this);

    }

    componentDidMount(){
        WindGenTurbineType3aIECService.getWindGenTurbineType3aIECById(this.state.id).then( (res) =>{
            let windGenTurbineType3aIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindGenTurbineType3aIEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3aIEC = {
            windGenTurbineType3aIECId: this.state.id,
        };
        console.log('windGenTurbineType3aIEC => ' + JSON.stringify(windGenTurbineType3aIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenTurbineType3aIECService.updateWindGenTurbineType3aIEC(windGenTurbineType3aIEC).then( res => {
            this.props.history.push('/windGenTurbineType3aIECs');
        });
    }


    cancel(){
        this.props.history.push('/windGenTurbineType3aIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenTurbineType3aIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenTurbineType3aIEC}>Save</button>
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

export default UpdateWindGenTurbineType3aIECComponent
