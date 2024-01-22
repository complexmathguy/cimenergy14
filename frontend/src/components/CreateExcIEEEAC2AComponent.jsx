import React, { Component } from 'react'
import ExcIEEEAC2AService from '../services/ExcIEEEAC2AService';

class CreateExcIEEEAC2AComponent extends Component {
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
            ExcIEEEAC2AService.getExcIEEEAC2AById(this.state.id).then( (res) =>{
                let excIEEEAC2A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC2A = (e) => {
        e.preventDefault();
        let excIEEEAC2A = {
                excIEEEAC2AId: this.state.id,
            };
        console.log('excIEEEAC2A => ' + JSON.stringify(excIEEEAC2A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC2A.excIEEEAC2AId=''
            ExcIEEEAC2AService.createExcIEEEAC2A(excIEEEAC2A).then(res =>{
                this.props.history.push('/excIEEEAC2As');
            });
        }else{
            ExcIEEEAC2AService.updateExcIEEEAC2A(excIEEEAC2A).then( res => {
                this.props.history.push('/excIEEEAC2As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEAC2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC2A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC2A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC2A}>Save</button>
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

export default CreateExcIEEEAC2AComponent
