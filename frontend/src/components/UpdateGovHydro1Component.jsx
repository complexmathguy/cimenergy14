import React, { Component } from 'react'
import GovHydro1Service from '../services/GovHydro1Service';

class UpdateGovHydro1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydro1 = this.updateGovHydro1.bind(this);

    }

    componentDidMount(){
        GovHydro1Service.getGovHydro1ById(this.state.id).then( (res) =>{
            let govHydro1 = res.data;
            this.setState({
            });
        });
    }

    updateGovHydro1 = (e) => {
        e.preventDefault();
        let govHydro1 = {
            govHydro1Id: this.state.id,
        };
        console.log('govHydro1 => ' + JSON.stringify(govHydro1));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydro1Service.updateGovHydro1(govHydro1).then( res => {
            this.props.history.push('/govHydro1s');
        });
    }


    cancel(){
        this.props.history.push('/govHydro1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydro1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydro1}>Save</button>
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

export default UpdateGovHydro1Component
