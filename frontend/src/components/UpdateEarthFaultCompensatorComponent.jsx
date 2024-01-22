import React, { Component } from 'react'
import EarthFaultCompensatorService from '../services/EarthFaultCompensatorService';

class UpdateEarthFaultCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEarthFaultCompensator = this.updateEarthFaultCompensator.bind(this);

    }

    componentDidMount(){
        EarthFaultCompensatorService.getEarthFaultCompensatorById(this.state.id).then( (res) =>{
            let earthFaultCompensator = res.data;
            this.setState({
            });
        });
    }

    updateEarthFaultCompensator = (e) => {
        e.preventDefault();
        let earthFaultCompensator = {
            earthFaultCompensatorId: this.state.id,
        };
        console.log('earthFaultCompensator => ' + JSON.stringify(earthFaultCompensator));
        console.log('id => ' + JSON.stringify(this.state.id));
        EarthFaultCompensatorService.updateEarthFaultCompensator(earthFaultCompensator).then( res => {
            this.props.history.push('/earthFaultCompensators');
        });
    }


    cancel(){
        this.props.history.push('/earthFaultCompensators');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EarthFaultCompensator</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEarthFaultCompensator}>Save</button>
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

export default UpdateEarthFaultCompensatorComponent
