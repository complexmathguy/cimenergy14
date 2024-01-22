import React, { Component } from 'react'
import PFVArType1IEEEPFControllerService from '../services/PFVArType1IEEEPFControllerService';

class CreatePFVArType1IEEEPFControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PFVArType1IEEEPFControllerService.getPFVArType1IEEEPFControllerById(this.state.id).then( (res) =>{
                let pFVArType1IEEEPFController = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePFVArType1IEEEPFController = (e) => {
        e.preventDefault();
        let pFVArType1IEEEPFController = {
                pFVArType1IEEEPFControllerId: this.state.id,
            };
        console.log('pFVArType1IEEEPFController => ' + JSON.stringify(pFVArType1IEEEPFController));

        // step 5
        if(this.state.id === '_add'){
            pFVArType1IEEEPFController.pFVArType1IEEEPFControllerId=''
            PFVArType1IEEEPFControllerService.createPFVArType1IEEEPFController(pFVArType1IEEEPFController).then(res =>{
                this.props.history.push('/pFVArType1IEEEPFControllers');
            });
        }else{
            PFVArType1IEEEPFControllerService.updatePFVArType1IEEEPFController(pFVArType1IEEEPFController).then( res => {
                this.props.history.push('/pFVArType1IEEEPFControllers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pFVArType1IEEEPFControllers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArType1IEEEPFController</h3>
        }else{
            return <h3 className="text-center">Update PFVArType1IEEEPFController</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArType1IEEEPFController}>Save</button>
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

export default CreatePFVArType1IEEEPFControllerComponent
