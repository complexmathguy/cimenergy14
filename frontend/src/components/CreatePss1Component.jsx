import React, { Component } from 'react'
import Pss1Service from '../services/Pss1Service';

class CreatePss1Component extends Component {
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
            Pss1Service.getPss1ById(this.state.id).then( (res) =>{
                let pss1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePss1 = (e) => {
        e.preventDefault();
        let pss1 = {
                pss1Id: this.state.id,
            };
        console.log('pss1 => ' + JSON.stringify(pss1));

        // step 5
        if(this.state.id === '_add'){
            pss1.pss1Id=''
            Pss1Service.createPss1(pss1).then(res =>{
                this.props.history.push('/pss1s');
            });
        }else{
            Pss1Service.updatePss1(pss1).then( res => {
                this.props.history.push('/pss1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pss1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Pss1</h3>
        }else{
            return <h3 className="text-center">Update Pss1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePss1}>Save</button>
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

export default CreatePss1Component
