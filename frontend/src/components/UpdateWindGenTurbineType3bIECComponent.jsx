import React, { Component } from 'react'
import WindGenTurbineType3bIECService from '../services/WindGenTurbineType3bIECService';

class UpdateWindGenTurbineType3bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindGenTurbineType3bIEC = this.updateWindGenTurbineType3bIEC.bind(this);

    }

    componentDidMount(){
        WindGenTurbineType3bIECService.getWindGenTurbineType3bIECById(this.state.id).then( (res) =>{
            let windGenTurbineType3bIEC = res.data;
            this.setState({
            });
        });
    }

    updateWindGenTurbineType3bIEC = (e) => {
        e.preventDefault();
        let windGenTurbineType3bIEC = {
            windGenTurbineType3bIECId: this.state.id,
        };
        console.log('windGenTurbineType3bIEC => ' + JSON.stringify(windGenTurbineType3bIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindGenTurbineType3bIECService.updateWindGenTurbineType3bIEC(windGenTurbineType3bIEC).then( res => {
            this.props.history.push('/windGenTurbineType3bIECs');
        });
    }


    cancel(){
        this.props.history.push('/windGenTurbineType3bIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindGenTurbineType3bIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindGenTurbineType3bIEC}>Save</button>
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

export default UpdateWindGenTurbineType3bIECComponent
