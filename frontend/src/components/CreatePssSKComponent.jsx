import React, { Component } from 'react'
import PssSKService from '../services/PssSKService';

class CreatePssSKComponent extends Component {
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
            PssSKService.getPssSKById(this.state.id).then( (res) =>{
                let pssSK = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePssSK = (e) => {
        e.preventDefault();
        let pssSK = {
                pssSKId: this.state.id,
            };
        console.log('pssSK => ' + JSON.stringify(pssSK));

        // step 5
        if(this.state.id === '_add'){
            pssSK.pssSKId=''
            PssSKService.createPssSK(pssSK).then(res =>{
                this.props.history.push('/pssSKs');
            });
        }else{
            PssSKService.updatePssSK(pssSK).then( res => {
                this.props.history.push('/pssSKs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pssSKs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssSK</h3>
        }else{
            return <h3 className="text-center">Update PssSK</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssSK}>Save</button>
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

export default CreatePssSKComponent
