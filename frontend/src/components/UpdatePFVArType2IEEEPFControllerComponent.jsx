import React, { Component } from 'react'
import PFVArType2IEEEPFControllerService from '../services/PFVArType2IEEEPFControllerService';

class UpdatePFVArType2IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePFVArType2IEEEPFController = this.updatePFVArType2IEEEPFController.bind(this);

    }

    componentDidMount(){
        PFVArType2IEEEPFControllerService.getPFVArType2IEEEPFControllerById(this.state.id).then( (res) =>{
            let pFVArType2IEEEPFController = res.data;
            this.setState({
            });
        });
    }

    updatePFVArType2IEEEPFController = (e) => {
        e.preventDefault();
        let pFVArType2IEEEPFController = {
            pFVArType2IEEEPFControllerId: this.state.id,
        };
        console.log('pFVArType2IEEEPFController => ' + JSON.stringify(pFVArType2IEEEPFController));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArType2IEEEPFControllerService.updatePFVArType2IEEEPFController(pFVArType2IEEEPFController).then( res => {
            this.props.history.push('/pFVArType2IEEEPFControllers');
        });
    }


    cancel(){
        this.props.history.push('/pFVArType2IEEEPFControllers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArType2IEEEPFController</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArType2IEEEPFController}>Save</button>
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

export default UpdatePFVArType2IEEEPFControllerComponent
