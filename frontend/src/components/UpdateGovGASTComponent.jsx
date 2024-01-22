import React, { Component } from 'react'
import GovGASTService from '../services/GovGASTService';

class UpdateGovGASTComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovGAST = this.updateGovGAST.bind(this);

    }

    componentDidMount(){
        GovGASTService.getGovGASTById(this.state.id).then( (res) =>{
            let govGAST = res.data;
            this.setState({
            });
        });
    }

    updateGovGAST = (e) => {
        e.preventDefault();
        let govGAST = {
            govGASTId: this.state.id,
        };
        console.log('govGAST => ' + JSON.stringify(govGAST));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGASTService.updateGovGAST(govGAST).then( res => {
            this.props.history.push('/govGASTs');
        });
    }


    cancel(){
        this.props.history.push('/govGASTs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGAST</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGAST}>Save</button>
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

export default UpdateGovGASTComponent
