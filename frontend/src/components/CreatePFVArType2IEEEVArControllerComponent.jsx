import React, { Component } from 'react'
import PFVArType2IEEEVArControllerService from '../services/PFVArType2IEEEVArControllerService';

class CreatePFVArType2IEEEVArControllerComponent extends Component {
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
            PFVArType2IEEEVArControllerService.getPFVArType2IEEEVArControllerById(this.state.id).then( (res) =>{
                let pFVArType2IEEEVArController = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePFVArType2IEEEVArController = (e) => {
        e.preventDefault();
        let pFVArType2IEEEVArController = {
                pFVArType2IEEEVArControllerId: this.state.id,
            };
        console.log('pFVArType2IEEEVArController => ' + JSON.stringify(pFVArType2IEEEVArController));

        // step 5
        if(this.state.id === '_add'){
            pFVArType2IEEEVArController.pFVArType2IEEEVArControllerId=''
            PFVArType2IEEEVArControllerService.createPFVArType2IEEEVArController(pFVArType2IEEEVArController).then(res =>{
                this.props.history.push('/pFVArType2IEEEVArControllers');
            });
        }else{
            PFVArType2IEEEVArControllerService.updatePFVArType2IEEEVArController(pFVArType2IEEEVArController).then( res => {
                this.props.history.push('/pFVArType2IEEEVArControllers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pFVArType2IEEEVArControllers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArType2IEEEVArController</h3>
        }else{
            return <h3 className="text-center">Update PFVArType2IEEEVArController</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArType2IEEEVArController}>Save</button>
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

export default CreatePFVArType2IEEEVArControllerComponent
