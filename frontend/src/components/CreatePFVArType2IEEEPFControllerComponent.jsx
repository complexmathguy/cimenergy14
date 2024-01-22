import React, { Component } from 'react'
import PFVArType2IEEEPFControllerService from '../services/PFVArType2IEEEPFControllerService';

class CreatePFVArType2IEEEPFControllerComponent extends Component {
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
            PFVArType2IEEEPFControllerService.getPFVArType2IEEEPFControllerById(this.state.id).then( (res) =>{
                let pFVArType2IEEEPFController = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePFVArType2IEEEPFController = (e) => {
        e.preventDefault();
        let pFVArType2IEEEPFController = {
                pFVArType2IEEEPFControllerId: this.state.id,
            };
        console.log('pFVArType2IEEEPFController => ' + JSON.stringify(pFVArType2IEEEPFController));

        // step 5
        if(this.state.id === '_add'){
            pFVArType2IEEEPFController.pFVArType2IEEEPFControllerId=''
            PFVArType2IEEEPFControllerService.createPFVArType2IEEEPFController(pFVArType2IEEEPFController).then(res =>{
                this.props.history.push('/pFVArType2IEEEPFControllers');
            });
        }else{
            PFVArType2IEEEPFControllerService.updatePFVArType2IEEEPFController(pFVArType2IEEEPFController).then( res => {
                this.props.history.push('/pFVArType2IEEEPFControllers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pFVArType2IEEEPFControllers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArType2IEEEPFController</h3>
        }else{
            return <h3 className="text-center">Update PFVArType2IEEEPFController</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArType2IEEEPFController}>Save</button>
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

export default CreatePFVArType2IEEEPFControllerComponent
