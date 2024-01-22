import React, { Component } from 'react'
import PFVArType1IEEEPFControllerService from '../services/PFVArType1IEEEPFControllerService';

class UpdatePFVArType1IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePFVArType1IEEEPFController = this.updatePFVArType1IEEEPFController.bind(this);

    }

    componentDidMount(){
        PFVArType1IEEEPFControllerService.getPFVArType1IEEEPFControllerById(this.state.id).then( (res) =>{
            let pFVArType1IEEEPFController = res.data;
            this.setState({
            });
        });
    }

    updatePFVArType1IEEEPFController = (e) => {
        e.preventDefault();
        let pFVArType1IEEEPFController = {
            pFVArType1IEEEPFControllerId: this.state.id,
        };
        console.log('pFVArType1IEEEPFController => ' + JSON.stringify(pFVArType1IEEEPFController));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArType1IEEEPFControllerService.updatePFVArType1IEEEPFController(pFVArType1IEEEPFController).then( res => {
            this.props.history.push('/pFVArType1IEEEPFControllers');
        });
    }


    cancel(){
        this.props.history.push('/pFVArType1IEEEPFControllers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArType1IEEEPFController</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArType1IEEEPFController}>Save</button>
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

export default UpdatePFVArType1IEEEPFControllerComponent
