import React, { Component } from 'react'
import GovGAST4Service from '../services/GovGAST4Service';

class UpdateGovGAST4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovGAST4 = this.updateGovGAST4.bind(this);

    }

    componentDidMount(){
        GovGAST4Service.getGovGAST4ById(this.state.id).then( (res) =>{
            let govGAST4 = res.data;
            this.setState({
            });
        });
    }

    updateGovGAST4 = (e) => {
        e.preventDefault();
        let govGAST4 = {
            govGAST4Id: this.state.id,
        };
        console.log('govGAST4 => ' + JSON.stringify(govGAST4));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGAST4Service.updateGovGAST4(govGAST4).then( res => {
            this.props.history.push('/govGAST4s');
        });
    }


    cancel(){
        this.props.history.push('/govGAST4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGAST4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGAST4}>Save</button>
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

export default UpdateGovGAST4Component
