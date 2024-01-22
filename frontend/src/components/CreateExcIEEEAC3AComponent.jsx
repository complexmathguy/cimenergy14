import React, { Component } from 'react'
import ExcIEEEAC3AService from '../services/ExcIEEEAC3AService';

class CreateExcIEEEAC3AComponent extends Component {
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
            ExcIEEEAC3AService.getExcIEEEAC3AById(this.state.id).then( (res) =>{
                let excIEEEAC3A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC3A = (e) => {
        e.preventDefault();
        let excIEEEAC3A = {
                excIEEEAC3AId: this.state.id,
            };
        console.log('excIEEEAC3A => ' + JSON.stringify(excIEEEAC3A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC3A.excIEEEAC3AId=''
            ExcIEEEAC3AService.createExcIEEEAC3A(excIEEEAC3A).then(res =>{
                this.props.history.push('/excIEEEAC3As');
            });
        }else{
            ExcIEEEAC3AService.updateExcIEEEAC3A(excIEEEAC3A).then( res => {
                this.props.history.push('/excIEEEAC3As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEAC3As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC3A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC3A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC3A}>Save</button>
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

export default CreateExcIEEEAC3AComponent
