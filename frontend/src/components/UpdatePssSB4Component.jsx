import React, { Component } from 'react'
import PssSB4Service from '../services/PssSB4Service';

class UpdatePssSB4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePssSB4 = this.updatePssSB4.bind(this);

    }

    componentDidMount(){
        PssSB4Service.getPssSB4ById(this.state.id).then( (res) =>{
            let pssSB4 = res.data;
            this.setState({
            });
        });
    }

    updatePssSB4 = (e) => {
        e.preventDefault();
        let pssSB4 = {
            pssSB4Id: this.state.id,
        };
        console.log('pssSB4 => ' + JSON.stringify(pssSB4));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssSB4Service.updatePssSB4(pssSB4).then( res => {
            this.props.history.push('/pssSB4s');
        });
    }


    cancel(){
        this.props.history.push('/pssSB4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssSB4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssSB4}>Save</button>
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

export default UpdatePssSB4Component
