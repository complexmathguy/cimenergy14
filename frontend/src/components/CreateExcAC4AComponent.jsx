import React, { Component } from 'react'
import ExcAC4AService from '../services/ExcAC4AService';

class CreateExcAC4AComponent extends Component {
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
            ExcAC4AService.getExcAC4AById(this.state.id).then( (res) =>{
                let excAC4A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAC4A = (e) => {
        e.preventDefault();
        let excAC4A = {
                excAC4AId: this.state.id,
            };
        console.log('excAC4A => ' + JSON.stringify(excAC4A));

        // step 5
        if(this.state.id === '_add'){
            excAC4A.excAC4AId=''
            ExcAC4AService.createExcAC4A(excAC4A).then(res =>{
                this.props.history.push('/excAC4As');
            });
        }else{
            ExcAC4AService.updateExcAC4A(excAC4A).then( res => {
                this.props.history.push('/excAC4As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAC4As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC4A</h3>
        }else{
            return <h3 className="text-center">Update ExcAC4A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC4A}>Save</button>
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

export default CreateExcAC4AComponent
