import React, { Component } from 'react'
import PssPTIST1Service from '../services/PssPTIST1Service';

class CreatePssPTIST1Component extends Component {
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
            PssPTIST1Service.getPssPTIST1ById(this.state.id).then( (res) =>{
                let pssPTIST1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePssPTIST1 = (e) => {
        e.preventDefault();
        let pssPTIST1 = {
                pssPTIST1Id: this.state.id,
            };
        console.log('pssPTIST1 => ' + JSON.stringify(pssPTIST1));

        // step 5
        if(this.state.id === '_add'){
            pssPTIST1.pssPTIST1Id=''
            PssPTIST1Service.createPssPTIST1(pssPTIST1).then(res =>{
                this.props.history.push('/pssPTIST1s');
            });
        }else{
            PssPTIST1Service.updatePssPTIST1(pssPTIST1).then( res => {
                this.props.history.push('/pssPTIST1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pssPTIST1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssPTIST1</h3>
        }else{
            return <h3 className="text-center">Update PssPTIST1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssPTIST1}>Save</button>
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

export default CreatePssPTIST1Component
