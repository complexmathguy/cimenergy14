import React, { Component } from 'react'
import ExcAC3AService from '../services/ExcAC3AService';

class CreateExcAC3AComponent extends Component {
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
            ExcAC3AService.getExcAC3AById(this.state.id).then( (res) =>{
                let excAC3A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcAC3A = (e) => {
        e.preventDefault();
        let excAC3A = {
                excAC3AId: this.state.id,
            };
        console.log('excAC3A => ' + JSON.stringify(excAC3A));

        // step 5
        if(this.state.id === '_add'){
            excAC3A.excAC3AId=''
            ExcAC3AService.createExcAC3A(excAC3A).then(res =>{
                this.props.history.push('/excAC3As');
            });
        }else{
            ExcAC3AService.updateExcAC3A(excAC3A).then( res => {
                this.props.history.push('/excAC3As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excAC3As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC3A</h3>
        }else{
            return <h3 className="text-center">Update ExcAC3A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC3A}>Save</button>
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

export default CreateExcAC3AComponent
