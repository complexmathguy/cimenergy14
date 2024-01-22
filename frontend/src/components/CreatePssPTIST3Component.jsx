import React, { Component } from 'react'
import PssPTIST3Service from '../services/PssPTIST3Service';

class CreatePssPTIST3Component extends Component {
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
            PssPTIST3Service.getPssPTIST3ById(this.state.id).then( (res) =>{
                let pssPTIST3 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePssPTIST3 = (e) => {
        e.preventDefault();
        let pssPTIST3 = {
                pssPTIST3Id: this.state.id,
            };
        console.log('pssPTIST3 => ' + JSON.stringify(pssPTIST3));

        // step 5
        if(this.state.id === '_add'){
            pssPTIST3.pssPTIST3Id=''
            PssPTIST3Service.createPssPTIST3(pssPTIST3).then(res =>{
                this.props.history.push('/pssPTIST3s');
            });
        }else{
            PssPTIST3Service.updatePssPTIST3(pssPTIST3).then( res => {
                this.props.history.push('/pssPTIST3s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pssPTIST3s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssPTIST3</h3>
        }else{
            return <h3 className="text-center">Update PssPTIST3</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssPTIST3}>Save</button>
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

export default CreatePssPTIST3Component
