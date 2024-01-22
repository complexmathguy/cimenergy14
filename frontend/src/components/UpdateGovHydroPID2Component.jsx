import React, { Component } from 'react'
import GovHydroPID2Service from '../services/GovHydroPID2Service';

class UpdateGovHydroPID2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydroPID2 = this.updateGovHydroPID2.bind(this);

    }

    componentDidMount(){
        GovHydroPID2Service.getGovHydroPID2ById(this.state.id).then( (res) =>{
            let govHydroPID2 = res.data;
            this.setState({
            });
        });
    }

    updateGovHydroPID2 = (e) => {
        e.preventDefault();
        let govHydroPID2 = {
            govHydroPID2Id: this.state.id,
        };
        console.log('govHydroPID2 => ' + JSON.stringify(govHydroPID2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroPID2Service.updateGovHydroPID2(govHydroPID2).then( res => {
            this.props.history.push('/govHydroPID2s');
        });
    }


    cancel(){
        this.props.history.push('/govHydroPID2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroPID2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroPID2}>Save</button>
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

export default UpdateGovHydroPID2Component
