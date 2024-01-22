import React, { Component } from 'react'
import ExcIEEEST2AService from '../services/ExcIEEEST2AService';

class CreateExcIEEEST2AComponent extends Component {
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
            ExcIEEEST2AService.getExcIEEEST2AById(this.state.id).then( (res) =>{
                let excIEEEST2A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST2A = (e) => {
        e.preventDefault();
        let excIEEEST2A = {
                excIEEEST2AId: this.state.id,
            };
        console.log('excIEEEST2A => ' + JSON.stringify(excIEEEST2A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST2A.excIEEEST2AId=''
            ExcIEEEST2AService.createExcIEEEST2A(excIEEEST2A).then(res =>{
                this.props.history.push('/excIEEEST2As');
            });
        }else{
            ExcIEEEST2AService.updateExcIEEEST2A(excIEEEST2A).then( res => {
                this.props.history.push('/excIEEEST2As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEST2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST2A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST2A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST2A}>Save</button>
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

export default CreateExcIEEEST2AComponent
