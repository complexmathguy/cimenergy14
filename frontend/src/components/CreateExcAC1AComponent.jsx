import React, { Component } from 'react'
import ExcAC1AService from '../services/ExcAC1AService';

class CreateExcAC1AComponent extends Component {
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
            ExcAC1AService.getExcAC1AById(this.state.id).then( (res) =>{
                let excAC1A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAC1A = (e) => {
        e.preventDefault();
        let excAC1A = {
                excAC1AId: this.state.id,
            };
        console.log('excAC1A => ' + JSON.stringify(excAC1A));

        // step 5
        if(this.state.id === '_add'){
            excAC1A.excAC1AId=''
            ExcAC1AService.createExcAC1A(excAC1A).then(res =>{
                this.props.history.push('/excAC1As');
            });
        }else{
            ExcAC1AService.updateExcAC1A(excAC1A).then( res => {
                this.props.history.push('/excAC1As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAC1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC1A</h3>
        }else{
            return <h3 className="text-center">Update ExcAC1A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC1A}>Save</button>
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

export default CreateExcAC1AComponent
