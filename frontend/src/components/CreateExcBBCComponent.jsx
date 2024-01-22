import React, { Component } from 'react'
import ExcBBCService from '../services/ExcBBCService';

class CreateExcBBCComponent extends Component {
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
            ExcBBCService.getExcBBCById(this.state.id).then( (res) =>{
                let excBBC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcBBC = (e) => {
        e.preventDefault();
        let excBBC = {
                excBBCId: this.state.id,
            };
        console.log('excBBC => ' + JSON.stringify(excBBC));

        // step 5
        if(this.state.id === '_add'){
            excBBC.excBBCId=''
            ExcBBCService.createExcBBC(excBBC).then(res =>{
                this.props.history.push('/excBBCs');
            });
        }else{
            ExcBBCService.updateExcBBC(excBBC).then( res => {
                this.props.history.push('/excBBCs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excBBCs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcBBC</h3>
        }else{
            return <h3 className="text-center">Update ExcBBC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcBBC}>Save</button>
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

export default CreateExcBBCComponent
