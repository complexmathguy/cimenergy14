import React, { Component } from 'react'
import PFVArType2IEEEVArControllerService from '../services/PFVArType2IEEEVArControllerService';

class UpdatePFVArType2IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePFVArType2IEEEVArController = this.updatePFVArType2IEEEVArController.bind(this);

    }

    componentDidMount(){
        PFVArType2IEEEVArControllerService.getPFVArType2IEEEVArControllerById(this.state.id).then( (res) =>{
            let pFVArType2IEEEVArController = res.data;
            this.setState({
            });
        });
    }

    updatePFVArType2IEEEVArController = (e) => {
        e.preventDefault();
        let pFVArType2IEEEVArController = {
            pFVArType2IEEEVArControllerId: this.state.id,
        };
        console.log('pFVArType2IEEEVArController => ' + JSON.stringify(pFVArType2IEEEVArController));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArType2IEEEVArControllerService.updatePFVArType2IEEEVArController(pFVArType2IEEEVArController).then( res => {
            this.props.history.push('/pFVArType2IEEEVArControllers');
        });
    }


    cancel(){
        this.props.history.push('/pFVArType2IEEEVArControllers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArType2IEEEVArController</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArType2IEEEVArController}>Save</button>
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

export default UpdatePFVArType2IEEEVArControllerComponent
