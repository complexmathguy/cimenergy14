import React, { Component } from 'react'
import GovHydroPeltonService from '../services/GovHydroPeltonService';

class UpdateGovHydroPeltonComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovHydroPelton = this.updateGovHydroPelton.bind(this);

    }

    componentDidMount(){
        GovHydroPeltonService.getGovHydroPeltonById(this.state.id).then( (res) =>{
            let govHydroPelton = res.data;
            this.setState({
            });
        });
    }

    updateGovHydroPelton = (e) => {
        e.preventDefault();
        let govHydroPelton = {
            govHydroPeltonId: this.state.id,
        };
        console.log('govHydroPelton => ' + JSON.stringify(govHydroPelton));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroPeltonService.updateGovHydroPelton(govHydroPelton).then( res => {
            this.props.history.push('/govHydroPeltons');
        });
    }


    cancel(){
        this.props.history.push('/govHydroPeltons');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroPelton</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroPelton}>Save</button>
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

export default UpdateGovHydroPeltonComponent
