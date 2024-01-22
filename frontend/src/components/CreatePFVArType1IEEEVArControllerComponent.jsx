import React, { Component } from 'react'
import PFVArType1IEEEVArControllerService from '../services/PFVArType1IEEEVArControllerService';

class CreatePFVArType1IEEEVArControllerComponent extends Component {
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
            PFVArType1IEEEVArControllerService.getPFVArType1IEEEVArControllerById(this.state.id).then( (res) =>{
                let pFVArType1IEEEVArController = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePFVArType1IEEEVArController = (e) => {
        e.preventDefault();
        let pFVArType1IEEEVArController = {
                pFVArType1IEEEVArControllerId: this.state.id,
            };
        console.log('pFVArType1IEEEVArController => ' + JSON.stringify(pFVArType1IEEEVArController));

        // step 5
        if(this.state.id === '_add'){
            pFVArType1IEEEVArController.pFVArType1IEEEVArControllerId=''
            PFVArType1IEEEVArControllerService.createPFVArType1IEEEVArController(pFVArType1IEEEVArController).then(res =>{
                this.props.history.push('/pFVArType1IEEEVArControllers');
            });
        }else{
            PFVArType1IEEEVArControllerService.updatePFVArType1IEEEVArController(pFVArType1IEEEVArController).then( res => {
                this.props.history.push('/pFVArType1IEEEVArControllers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pFVArType1IEEEVArControllers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArType1IEEEVArController</h3>
        }else{
            return <h3 className="text-center">Update PFVArType1IEEEVArController</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArType1IEEEVArController}>Save</button>
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

export default CreatePFVArType1IEEEVArControllerComponent
