import React, { Component } from 'react'
import ExcIEEEAC6AService from '../services/ExcIEEEAC6AService';

class CreateExcIEEEAC6AComponent extends Component {
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
            ExcIEEEAC6AService.getExcIEEEAC6AById(this.state.id).then( (res) =>{
                let excIEEEAC6A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC6A = (e) => {
        e.preventDefault();
        let excIEEEAC6A = {
                excIEEEAC6AId: this.state.id,
            };
        console.log('excIEEEAC6A => ' + JSON.stringify(excIEEEAC6A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC6A.excIEEEAC6AId=''
            ExcIEEEAC6AService.createExcIEEEAC6A(excIEEEAC6A).then(res =>{
                this.props.history.push('/excIEEEAC6As');
            });
        }else{
            ExcIEEEAC6AService.updateExcIEEEAC6A(excIEEEAC6A).then( res => {
                this.props.history.push('/excIEEEAC6As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEAC6As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC6A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC6A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC6A}>Save</button>
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

export default CreateExcIEEEAC6AComponent
