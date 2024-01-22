import React, { Component } from 'react'
import VAdjIEEEService from '../services/VAdjIEEEService';

class UpdateVAdjIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateVAdjIEEE = this.updateVAdjIEEE.bind(this);

    }

    componentDidMount(){
        VAdjIEEEService.getVAdjIEEEById(this.state.id).then( (res) =>{
            let vAdjIEEE = res.data;
            this.setState({
            });
        });
    }

    updateVAdjIEEE = (e) => {
        e.preventDefault();
        let vAdjIEEE = {
            vAdjIEEEId: this.state.id,
        };
        console.log('vAdjIEEE => ' + JSON.stringify(vAdjIEEE));
        console.log('id => ' + JSON.stringify(this.state.id));
        VAdjIEEEService.updateVAdjIEEE(vAdjIEEE).then( res => {
            this.props.history.push('/vAdjIEEEs');
        });
    }


    cancel(){
        this.props.history.push('/vAdjIEEEs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VAdjIEEE</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVAdjIEEE}>Save</button>
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

export default UpdateVAdjIEEEComponent
