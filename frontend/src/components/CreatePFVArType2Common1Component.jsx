import React, { Component } from 'react'
import PFVArType2Common1Service from '../services/PFVArType2Common1Service';

class CreatePFVArType2Common1Component extends Component {
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
            PFVArType2Common1Service.getPFVArType2Common1ById(this.state.id).then( (res) =>{
                let pFVArType2Common1 = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePFVArType2Common1 = (e) => {
        e.preventDefault();
        let pFVArType2Common1 = {
                pFVArType2Common1Id: this.state.id,
            };
        console.log('pFVArType2Common1 => ' + JSON.stringify(pFVArType2Common1));

        // step 5
        if(this.state.id === '_add'){
            pFVArType2Common1.pFVArType2Common1Id=''
            PFVArType2Common1Service.createPFVArType2Common1(pFVArType2Common1).then(res =>{
                this.props.history.push('/pFVArType2Common1s');
            });
        }else{
            PFVArType2Common1Service.updatePFVArType2Common1(pFVArType2Common1).then( res => {
                this.props.history.push('/pFVArType2Common1s');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/pFVArType2Common1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PFVArType2Common1</h3>
        }else{
            return <h3 className="text-center">Update PFVArType2Common1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePFVArType2Common1}>Save</button>
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

export default CreatePFVArType2Common1Component
