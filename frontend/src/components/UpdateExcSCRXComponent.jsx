import React, { Component } from 'react'
import ExcSCRXService from '../services/ExcSCRXService';

class UpdateExcSCRXComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateExcSCRX = this.updateExcSCRX.bind(this);

    }

    componentDidMount(){
        ExcSCRXService.getExcSCRXById(this.state.id).then( (res) =>{
            let excSCRX = res.data;
            this.setState({
            });
        });
    }

    updateExcSCRX = (e) => {
        e.preventDefault();
        let excSCRX = {
            excSCRXId: this.state.id,
        };
        console.log('excSCRX => ' + JSON.stringify(excSCRX));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcSCRXService.updateExcSCRX(excSCRX).then( res => {
            this.props.history.push('/excSCRXs');
        });
    }


    cancel(){
        this.props.history.push('/excSCRXs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcSCRX</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcSCRX}>Save</button>
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

export default UpdateExcSCRXComponent
