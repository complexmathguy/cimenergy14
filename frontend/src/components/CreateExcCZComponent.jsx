import React, { Component } from 'react'
import ExcCZService from '../services/ExcCZService';

class CreateExcCZComponent extends Component {
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
            ExcCZService.getExcCZById(this.state.id).then( (res) =>{
                let excCZ = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcCZ = (e) => {
        e.preventDefault();
        let excCZ = {
                excCZId: this.state.id,
            };
        console.log('excCZ => ' + JSON.stringify(excCZ));

        // step 5
        if(this.state.id === '_add'){
            excCZ.excCZId=''
            ExcCZService.createExcCZ(excCZ).then(res =>{
                this.props.history.push('/excCZs');
            });
        }else{
            ExcCZService.updateExcCZ(excCZ).then( res => {
                this.props.history.push('/excCZs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excCZs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcCZ</h3>
        }else{
            return <h3 className="text-center">Update ExcCZ</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcCZ}>Save</button>
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

export default CreateExcCZComponent
