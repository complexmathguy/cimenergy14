import React, { Component } from 'react'
import PssSB4Service from '../services/PssSB4Service';

class CreatePssSB4Component extends Component {
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
            PssSB4Service.getPssSB4ById(this.state.id).then( (res) =>{
                let pssSB4 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePssSB4 = (e) => {
        e.preventDefault();
        let pssSB4 = {
                pssSB4Id: this.state.id,
            };
        console.log('pssSB4 => ' + JSON.stringify(pssSB4));

        // step 5
        if(this.state.id === '_add'){
            pssSB4.pssSB4Id=''
            PssSB4Service.createPssSB4(pssSB4).then(res =>{
                this.props.history.push('/pssSB4s');
            });
        }else{
            PssSB4Service.updatePssSB4(pssSB4).then( res => {
                this.props.history.push('/pssSB4s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pssSB4s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssSB4</h3>
        }else{
            return <h3 className="text-center">Update PssSB4</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssSB4}>Save</button>
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

export default CreatePssSB4Component
