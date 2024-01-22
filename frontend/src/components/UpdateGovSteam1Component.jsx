import React, { Component } from 'react'
import GovSteam1Service from '../services/GovSteam1Service';

class UpdateGovSteam1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovSteam1 = this.updateGovSteam1.bind(this);

    }

    componentDidMount(){
        GovSteam1Service.getGovSteam1ById(this.state.id).then( (res) =>{
            let govSteam1 = res.data;
            this.setState({
            });
        });
    }

    updateGovSteam1 = (e) => {
        e.preventDefault();
        let govSteam1 = {
            govSteam1Id: this.state.id,
        };
        console.log('govSteam1 => ' + JSON.stringify(govSteam1));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteam1Service.updateGovSteam1(govSteam1).then( res => {
            this.props.history.push('/govSteam1s');
        });
    }


    cancel(){
        this.props.history.push('/govSteam1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteam1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteam1}>Save</button>
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

export default UpdateGovSteam1Component
