import React, { Component } from 'react'
import PssSKService from '../services/PssSKService';

class UpdatePssSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePssSK = this.updatePssSK.bind(this);

    }

    componentDidMount(){
        PssSKService.getPssSKById(this.state.id).then( (res) =>{
            let pssSK = res.data;
            this.setState({
            });
        });
    }

    updatePssSK = (e) => {
        e.preventDefault();
        let pssSK = {
            pssSKId: this.state.id,
        };
        console.log('pssSK => ' + JSON.stringify(pssSK));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssSKService.updatePssSK(pssSK).then( res => {
            this.props.history.push('/pssSKs');
        });
    }


    cancel(){
        this.props.history.push('/pssSKs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssSK</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssSK}>Save</button>
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

export default UpdatePssSKComponent
