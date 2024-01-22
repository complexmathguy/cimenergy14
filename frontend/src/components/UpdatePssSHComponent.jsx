import React, { Component } from 'react'
import PssSHService from '../services/PssSHService';

class UpdatePssSHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePssSH = this.updatePssSH.bind(this);

    }

    componentDidMount(){
        PssSHService.getPssSHById(this.state.id).then( (res) =>{
            let pssSH = res.data;
            this.setState({
            });
        });
    }

    updatePssSH = (e) => {
        e.preventDefault();
        let pssSH = {
            pssSHId: this.state.id,
        };
        console.log('pssSH => ' + JSON.stringify(pssSH));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssSHService.updatePssSH(pssSH).then( res => {
            this.props.history.push('/pssSHs');
        });
    }


    cancel(){
        this.props.history.push('/pssSHs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssSH</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssSH}>Save</button>
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

export default UpdatePssSHComponent
