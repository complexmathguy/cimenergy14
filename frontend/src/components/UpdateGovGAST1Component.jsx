import React, { Component } from 'react'
import GovGAST1Service from '../services/GovGAST1Service';

class UpdateGovGAST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovGAST1 = this.updateGovGAST1.bind(this);

    }

    componentDidMount(){
        GovGAST1Service.getGovGAST1ById(this.state.id).then( (res) =>{
            let govGAST1 = res.data;
            this.setState({
            });
        });
    }

    updateGovGAST1 = (e) => {
        e.preventDefault();
        let govGAST1 = {
            govGAST1Id: this.state.id,
        };
        console.log('govGAST1 => ' + JSON.stringify(govGAST1));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGAST1Service.updateGovGAST1(govGAST1).then( res => {
            this.props.history.push('/govGAST1s');
        });
    }


    cancel(){
        this.props.history.push('/govGAST1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGAST1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGAST1}>Save</button>
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

export default UpdateGovGAST1Component
