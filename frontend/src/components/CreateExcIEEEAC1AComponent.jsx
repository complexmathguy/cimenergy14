import React, { Component } from 'react'
import ExcIEEEAC1AService from '../services/ExcIEEEAC1AService';

class CreateExcIEEEAC1AComponent extends Component {
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
            ExcIEEEAC1AService.getExcIEEEAC1AById(this.state.id).then( (res) =>{
                let excIEEEAC1A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC1A = (e) => {
        e.preventDefault();
        let excIEEEAC1A = {
                excIEEEAC1AId: this.state.id,
            };
        console.log('excIEEEAC1A => ' + JSON.stringify(excIEEEAC1A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC1A.excIEEEAC1AId=''
            ExcIEEEAC1AService.createExcIEEEAC1A(excIEEEAC1A).then(res =>{
                this.props.history.push('/excIEEEAC1As');
            });
        }else{
            ExcIEEEAC1AService.updateExcIEEEAC1A(excIEEEAC1A).then( res => {
                this.props.history.push('/excIEEEAC1As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEAC1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC1A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC1A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC1A}>Save</button>
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

export default CreateExcIEEEAC1AComponent
