import React, { Component } from 'react'
import ExcIEEEST3AService from '../services/ExcIEEEST3AService';

class CreateExcIEEEST3AComponent extends Component {
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
            ExcIEEEST3AService.getExcIEEEST3AById(this.state.id).then( (res) =>{
                let excIEEEST3A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST3A = (e) => {
        e.preventDefault();
        let excIEEEST3A = {
                excIEEEST3AId: this.state.id,
            };
        console.log('excIEEEST3A => ' + JSON.stringify(excIEEEST3A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST3A.excIEEEST3AId=''
            ExcIEEEST3AService.createExcIEEEST3A(excIEEEST3A).then(res =>{
                this.props.history.push('/excIEEEST3As');
            });
        }else{
            ExcIEEEST3AService.updateExcIEEEST3A(excIEEEST3A).then( res => {
                this.props.history.push('/excIEEEST3As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEST3As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST3A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST3A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST3A}>Save</button>
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

export default CreateExcIEEEST3AComponent
