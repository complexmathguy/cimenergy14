import React, { Component } from 'react'
import GovHydro4Service from '../services/GovHydro4Service';

class UpdateGovHydro4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydro4 = this.updateGovHydro4.bind(this);

    }

    componentDidMount(){
        GovHydro4Service.getGovHydro4ById(this.state.id).then( (res) =>{
            let govHydro4 = res.data;
            this.setState({
            });
        });
    }

    updateGovHydro4 = (e) => {
        e.preventDefault();
        let govHydro4 = {
            govHydro4Id: this.state.id,
        };
        console.log('govHydro4 => ' + JSON.stringify(govHydro4));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydro4Service.updateGovHydro4(govHydro4).then( res => {
            this.props.history.push('/govHydro4s');
        });
    }


    cancel(){
        this.props.history.push('/govHydro4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydro4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydro4}>Save</button>
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

export default UpdateGovHydro4Component
