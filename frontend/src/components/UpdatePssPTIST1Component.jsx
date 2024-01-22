import React, { Component } from 'react'
import PssPTIST1Service from '../services/PssPTIST1Service';

class UpdatePssPTIST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePssPTIST1 = this.updatePssPTIST1.bind(this);

    }

    componentDidMount(){
        PssPTIST1Service.getPssPTIST1ById(this.state.id).then( (res) =>{
            let pssPTIST1 = res.data;
            this.setState({
            });
        });
    }

    updatePssPTIST1 = (e) => {
        e.preventDefault();
        let pssPTIST1 = {
            pssPTIST1Id: this.state.id,
        };
        console.log('pssPTIST1 => ' + JSON.stringify(pssPTIST1));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssPTIST1Service.updatePssPTIST1(pssPTIST1).then( res => {
            this.props.history.push('/pssPTIST1s');
        });
    }


    cancel(){
        this.props.history.push('/pssPTIST1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssPTIST1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssPTIST1}>Save</button>
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

export default UpdatePssPTIST1Component
