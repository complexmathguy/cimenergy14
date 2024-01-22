import React, { Component } from 'react'
import GovHydro3Service from '../services/GovHydro3Service';

class UpdateGovHydro3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydro3 = this.updateGovHydro3.bind(this);

    }

    componentDidMount(){
        GovHydro3Service.getGovHydro3ById(this.state.id).then( (res) =>{
            let govHydro3 = res.data;
            this.setState({
            });
        });
    }

    updateGovHydro3 = (e) => {
        e.preventDefault();
        let govHydro3 = {
            govHydro3Id: this.state.id,
        };
        console.log('govHydro3 => ' + JSON.stringify(govHydro3));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydro3Service.updateGovHydro3(govHydro3).then( res => {
            this.props.history.push('/govHydro3s');
        });
    }


    cancel(){
        this.props.history.push('/govHydro3s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydro3</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydro3}>Save</button>
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

export default UpdateGovHydro3Component
