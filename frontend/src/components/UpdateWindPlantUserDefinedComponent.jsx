import React, { Component } from 'react'
import WindPlantUserDefinedService from '../services/WindPlantUserDefinedService';

class UpdateWindPlantUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateWindPlantUserDefined = this.updateWindPlantUserDefined.bind(this);

    }

    componentDidMount(){
        WindPlantUserDefinedService.getWindPlantUserDefinedById(this.state.id).then( (res) =>{
            let windPlantUserDefined = res.data;
            this.setState({
            });
        });
    }

    updateWindPlantUserDefined = (e) => {
        e.preventDefault();
        let windPlantUserDefined = {
            windPlantUserDefinedId: this.state.id,
        };
        console.log('windPlantUserDefined => ' + JSON.stringify(windPlantUserDefined));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPlantUserDefinedService.updateWindPlantUserDefined(windPlantUserDefined).then( res => {
            this.props.history.push('/windPlantUserDefineds');
        });
    }


    cancel(){
        this.props.history.push('/windPlantUserDefineds');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPlantUserDefined</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPlantUserDefined}>Save</button>
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

export default UpdateWindPlantUserDefinedComponent
