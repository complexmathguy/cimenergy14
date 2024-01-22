import React, { Component } from 'react'
import ExcAC5AService from '../services/ExcAC5AService';

class CreateExcAC5AComponent extends Component {
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
            ExcAC5AService.getExcAC5AById(this.state.id).then( (res) =>{
                let excAC5A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAC5A = (e) => {
        e.preventDefault();
        let excAC5A = {
                excAC5AId: this.state.id,
            };
        console.log('excAC5A => ' + JSON.stringify(excAC5A));

        // step 5
        if(this.state.id === '_add'){
            excAC5A.excAC5AId=''
            ExcAC5AService.createExcAC5A(excAC5A).then(res =>{
                this.props.history.push('/excAC5As');
            });
        }else{
            ExcAC5AService.updateExcAC5A(excAC5A).then( res => {
                this.props.history.push('/excAC5As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAC5As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC5A</h3>
        }else{
            return <h3 className="text-center">Update ExcAC5A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC5A}>Save</button>
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

export default CreateExcAC5AComponent
