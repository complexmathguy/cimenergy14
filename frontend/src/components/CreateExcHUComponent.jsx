import React, { Component } from 'react'
import ExcHUService from '../services/ExcHUService';

class CreateExcHUComponent extends Component {
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
            ExcHUService.getExcHUById(this.state.id).then( (res) =>{
                let excHU = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcHU = (e) => {
        e.preventDefault();
        let excHU = {
                excHUId: this.state.id,
            };
        console.log('excHU => ' + JSON.stringify(excHU));

        // step 5
        if(this.state.id === '_add'){
            excHU.excHUId=''
            ExcHUService.createExcHU(excHU).then(res =>{
                this.props.history.push('/excHUs');
            });
        }else{
            ExcHUService.updateExcHU(excHU).then( res => {
                this.props.history.push('/excHUs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excHUs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcHU</h3>
        }else{
            return <h3 className="text-center">Update ExcHU</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcHU}>Save</button>
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

export default CreateExcHUComponent
