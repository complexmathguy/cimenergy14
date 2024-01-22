import React, { Component } from 'react'
import GovGASTWDService from '../services/GovGASTWDService';

class UpdateGovGASTWDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovGASTWD = this.updateGovGASTWD.bind(this);

    }

    componentDidMount(){
        GovGASTWDService.getGovGASTWDById(this.state.id).then( (res) =>{
            let govGASTWD = res.data;
            this.setState({
            });
        });
    }

    updateGovGASTWD = (e) => {
        e.preventDefault();
        let govGASTWD = {
            govGASTWDId: this.state.id,
        };
        console.log('govGASTWD => ' + JSON.stringify(govGASTWD));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGASTWDService.updateGovGASTWD(govGASTWD).then( res => {
            this.props.history.push('/govGASTWDs');
        });
    }


    cancel(){
        this.props.history.push('/govGASTWDs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGASTWD</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGASTWD}>Save</button>
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

export default UpdateGovGASTWDComponent
