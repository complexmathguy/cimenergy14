import React, { Component } from 'react'
import VAdjIEEEService from '../services/VAdjIEEEService';

class CreateVAdjIEEEComponent extends Component {
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
            VAdjIEEEService.getVAdjIEEEById(this.state.id).then( (res) =>{
                let vAdjIEEE = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateVAdjIEEE = (e) => {
        e.preventDefault();
        let vAdjIEEE = {
                vAdjIEEEId: this.state.id,
            };
        console.log('vAdjIEEE => ' + JSON.stringify(vAdjIEEE));

        // step 5
        if(this.state.id === '_add'){
            vAdjIEEE.vAdjIEEEId=''
            VAdjIEEEService.createVAdjIEEE(vAdjIEEE).then(res =>{
                this.props.history.push('/vAdjIEEEs');
            });
        }else{
            VAdjIEEEService.updateVAdjIEEE(vAdjIEEE).then( res => {
                this.props.history.push('/vAdjIEEEs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/vAdjIEEEs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VAdjIEEE</h3>
        }else{
            return <h3 className="text-center">Update VAdjIEEE</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVAdjIEEE}>Save</button>
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

export default CreateVAdjIEEEComponent
