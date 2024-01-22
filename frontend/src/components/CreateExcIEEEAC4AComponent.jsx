import React, { Component } from 'react'
import ExcIEEEAC4AService from '../services/ExcIEEEAC4AService';

class CreateExcIEEEAC4AComponent extends Component {
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
            ExcIEEEAC4AService.getExcIEEEAC4AById(this.state.id).then( (res) =>{
                let excIEEEAC4A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC4A = (e) => {
        e.preventDefault();
        let excIEEEAC4A = {
                excIEEEAC4AId: this.state.id,
            };
        console.log('excIEEEAC4A => ' + JSON.stringify(excIEEEAC4A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC4A.excIEEEAC4AId=''
            ExcIEEEAC4AService.createExcIEEEAC4A(excIEEEAC4A).then(res =>{
                this.props.history.push('/excIEEEAC4As');
            });
        }else{
            ExcIEEEAC4AService.updateExcIEEEAC4A(excIEEEAC4A).then( res => {
                this.props.history.push('/excIEEEAC4As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEAC4As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC4A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC4A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC4A}>Save</button>
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

export default CreateExcIEEEAC4AComponent
