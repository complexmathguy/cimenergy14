import React, { Component } from 'react'
import ExcDC2AService from '../services/ExcDC2AService';

class CreateExcDC2AComponent extends Component {
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
            ExcDC2AService.getExcDC2AById(this.state.id).then( (res) =>{
                let excDC2A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcDC2A = (e) => {
        e.preventDefault();
        let excDC2A = {
                excDC2AId: this.state.id,
            };
        console.log('excDC2A => ' + JSON.stringify(excDC2A));

        // step 5
        if(this.state.id === '_add'){
            excDC2A.excDC2AId=''
            ExcDC2AService.createExcDC2A(excDC2A).then(res =>{
                this.props.history.push('/excDC2As');
            });
        }else{
            ExcDC2AService.updateExcDC2A(excDC2A).then( res => {
                this.props.history.push('/excDC2As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excDC2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcDC2A</h3>
        }else{
            return <h3 className="text-center">Update ExcDC2A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcDC2A}>Save</button>
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

export default CreateExcDC2AComponent
