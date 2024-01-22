import React, { Component } from 'react'
import ExcIEEEAC5AService from '../services/ExcIEEEAC5AService';

class CreateExcIEEEAC5AComponent extends Component {
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
            ExcIEEEAC5AService.getExcIEEEAC5AById(this.state.id).then( (res) =>{
                let excIEEEAC5A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC5A = (e) => {
        e.preventDefault();
        let excIEEEAC5A = {
                excIEEEAC5AId: this.state.id,
            };
        console.log('excIEEEAC5A => ' + JSON.stringify(excIEEEAC5A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC5A.excIEEEAC5AId=''
            ExcIEEEAC5AService.createExcIEEEAC5A(excIEEEAC5A).then(res =>{
                this.props.history.push('/excIEEEAC5As');
            });
        }else{
            ExcIEEEAC5AService.updateExcIEEEAC5A(excIEEEAC5A).then( res => {
                this.props.history.push('/excIEEEAC5As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEAC5As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC5A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC5A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC5A}>Save</button>
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

export default CreateExcIEEEAC5AComponent
