import React, { Component } from 'react'
import GovHydro2Service from '../services/GovHydro2Service';

class UpdateGovHydro2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydro2 = this.updateGovHydro2.bind(this);

    }

    componentDidMount(){
        GovHydro2Service.getGovHydro2ById(this.state.id).then( (res) =>{
            let govHydro2 = res.data;
            this.setState({
            });
        });
    }

    updateGovHydro2 = (e) => {
        e.preventDefault();
        let govHydro2 = {
            govHydro2Id: this.state.id,
        };
        console.log('govHydro2 => ' + JSON.stringify(govHydro2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydro2Service.updateGovHydro2(govHydro2).then( res => {
            this.props.history.push('/govHydro2s');
        });
    }


    cancel(){
        this.props.history.push('/govHydro2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydro2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydro2}>Save</button>
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

export default UpdateGovHydro2Component
