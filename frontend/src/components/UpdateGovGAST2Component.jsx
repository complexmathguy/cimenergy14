import React, { Component } from 'react'
import GovGAST2Service from '../services/GovGAST2Service';

class UpdateGovGAST2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovGAST2 = this.updateGovGAST2.bind(this);

    }

    componentDidMount(){
        GovGAST2Service.getGovGAST2ById(this.state.id).then( (res) =>{
            let govGAST2 = res.data;
            this.setState({
            });
        });
    }

    updateGovGAST2 = (e) => {
        e.preventDefault();
        let govGAST2 = {
            govGAST2Id: this.state.id,
        };
        console.log('govGAST2 => ' + JSON.stringify(govGAST2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGAST2Service.updateGovGAST2(govGAST2).then( res => {
            this.props.history.push('/govGAST2s');
        });
    }


    cancel(){
        this.props.history.push('/govGAST2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGAST2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGAST2}>Save</button>
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

export default UpdateGovGAST2Component
