import React, { Component } from 'react'
import GovGAST3Service from '../services/GovGAST3Service';

class UpdateGovGAST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGovGAST3 = this.updateGovGAST3.bind(this);

    }

    componentDidMount(){
        GovGAST3Service.getGovGAST3ById(this.state.id).then( (res) =>{
            let govGAST3 = res.data;
            this.setState({
            });
        });
    }

    updateGovGAST3 = (e) => {
        e.preventDefault();
        let govGAST3 = {
            govGAST3Id: this.state.id,
        };
        console.log('govGAST3 => ' + JSON.stringify(govGAST3));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGAST3Service.updateGovGAST3(govGAST3).then( res => {
            this.props.history.push('/govGAST3s');
        });
    }


    cancel(){
        this.props.history.push('/govGAST3s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGAST3</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGAST3}>Save</button>
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

export default UpdateGovGAST3Component
