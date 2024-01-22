import React, { Component } from 'react'
import ExcAC2AService from '../services/ExcAC2AService';

class CreateExcAC2AComponent extends Component {
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
            ExcAC2AService.getExcAC2AById(this.state.id).then( (res) =>{
                let excAC2A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAC2A = (e) => {
        e.preventDefault();
        let excAC2A = {
                excAC2AId: this.state.id,
            };
        console.log('excAC2A => ' + JSON.stringify(excAC2A));

        // step 5
        if(this.state.id === '_add'){
            excAC2A.excAC2AId=''
            ExcAC2AService.createExcAC2A(excAC2A).then(res =>{
                this.props.history.push('/excAC2As');
            });
        }else{
            ExcAC2AService.updateExcAC2A(excAC2A).then( res => {
                this.props.history.push('/excAC2As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAC2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC2A</h3>
        }else{
            return <h3 className="text-center">Update ExcAC2A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC2A}>Save</button>
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

export default CreateExcAC2AComponent
