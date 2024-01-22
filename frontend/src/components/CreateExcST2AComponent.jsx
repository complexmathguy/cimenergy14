import React, { Component } from 'react'
import ExcST2AService from '../services/ExcST2AService';

class CreateExcST2AComponent extends Component {
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
            ExcST2AService.getExcST2AById(this.state.id).then( (res) =>{
                let excST2A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcST2A = (e) => {
        e.preventDefault();
        let excST2A = {
                excST2AId: this.state.id,
            };
        console.log('excST2A => ' + JSON.stringify(excST2A));

        // step 5
        if(this.state.id === '_add'){
            excST2A.excST2AId=''
            ExcST2AService.createExcST2A(excST2A).then(res =>{
                this.props.history.push('/excST2As');
            });
        }else{
            ExcST2AService.updateExcST2A(excST2A).then( res => {
                this.props.history.push('/excST2As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excST2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcST2A</h3>
        }else{
            return <h3 className="text-center">Update ExcST2A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcST2A}>Save</button>
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

export default CreateExcST2AComponent
