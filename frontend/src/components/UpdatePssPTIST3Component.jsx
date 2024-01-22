import React, { Component } from 'react'
import PssPTIST3Service from '../services/PssPTIST3Service';

class UpdatePssPTIST3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePssPTIST3 = this.updatePssPTIST3.bind(this);

    }

    componentDidMount(){
        PssPTIST3Service.getPssPTIST3ById(this.state.id).then( (res) =>{
            let pssPTIST3 = res.data;
            this.setState({
            });
        });
    }

    updatePssPTIST3 = (e) => {
        e.preventDefault();
        let pssPTIST3 = {
            pssPTIST3Id: this.state.id,
        };
        console.log('pssPTIST3 => ' + JSON.stringify(pssPTIST3));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssPTIST3Service.updatePssPTIST3(pssPTIST3).then( res => {
            this.props.history.push('/pssPTIST3s');
        });
    }


    cancel(){
        this.props.history.push('/pssPTIST3s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssPTIST3</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssPTIST3}>Save</button>
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

export default UpdatePssPTIST3Component
