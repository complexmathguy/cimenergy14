import React, { Component } from 'react'
import Pss5Service from '../services/Pss5Service';

class CreatePss5Component extends Component {
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
            Pss5Service.getPss5ById(this.state.id).then( (res) =>{
                let pss5 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePss5 = (e) => {
        e.preventDefault();
        let pss5 = {
                pss5Id: this.state.id,
            };
        console.log('pss5 => ' + JSON.stringify(pss5));

        // step 5
        if(this.state.id === '_add'){
            pss5.pss5Id=''
            Pss5Service.createPss5(pss5).then(res =>{
                this.props.history.push('/pss5s');
            });
        }else{
            Pss5Service.updatePss5(pss5).then( res => {
                this.props.history.push('/pss5s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pss5s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Pss5</h3>
        }else{
            return <h3 className="text-center">Update Pss5</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePss5}>Save</button>
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

export default CreatePss5Component
