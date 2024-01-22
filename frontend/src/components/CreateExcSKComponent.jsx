import React, { Component } from 'react'
import ExcSKService from '../services/ExcSKService';

class CreateExcSKComponent extends Component {
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
            ExcSKService.getExcSKById(this.state.id).then( (res) =>{
                let excSK = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcSK = (e) => {
        e.preventDefault();
        let excSK = {
                excSKId: this.state.id,
            };
        console.log('excSK => ' + JSON.stringify(excSK));

        // step 5
        if(this.state.id === '_add'){
            excSK.excSKId=''
            ExcSKService.createExcSK(excSK).then(res =>{
                this.props.history.push('/excSKs');
            });
        }else{
            ExcSKService.updateExcSK(excSK).then( res => {
                this.props.history.push('/excSKs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excSKs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcSK</h3>
        }else{
            return <h3 className="text-center">Update ExcSK</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcSK}>Save</button>
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

export default CreateExcSKComponent
