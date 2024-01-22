import React, { Component } from 'react'
import GovHydroPIDService from '../services/GovHydroPIDService';

class UpdateGovHydroPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydroPID = this.updateGovHydroPID.bind(this);

    }

    componentDidMount(){
        GovHydroPIDService.getGovHydroPIDById(this.state.id).then( (res) =>{
            let govHydroPID = res.data;
            this.setState({
            });
        });
    }

    updateGovHydroPID = (e) => {
        e.preventDefault();
        let govHydroPID = {
            govHydroPIDId: this.state.id,
        };
        console.log('govHydroPID => ' + JSON.stringify(govHydroPID));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroPIDService.updateGovHydroPID(govHydroPID).then( res => {
            this.props.history.push('/govHydroPIDs');
        });
    }


    cancel(){
        this.props.history.push('/govHydroPIDs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroPID</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroPID}>Save</button>
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

export default UpdateGovHydroPIDComponent
