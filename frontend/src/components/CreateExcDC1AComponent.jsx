import React, { Component } from 'react'
import ExcDC1AService from '../services/ExcDC1AService';

class CreateExcDC1AComponent extends Component {
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
            ExcDC1AService.getExcDC1AById(this.state.id).then( (res) =>{
                let excDC1A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcDC1A = (e) => {
        e.preventDefault();
        let excDC1A = {
                excDC1AId: this.state.id,
            };
        console.log('excDC1A => ' + JSON.stringify(excDC1A));

        // step 5
        if(this.state.id === '_add'){
            excDC1A.excDC1AId=''
            ExcDC1AService.createExcDC1A(excDC1A).then(res =>{
                this.props.history.push('/excDC1As');
            });
        }else{
            ExcDC1AService.updateExcDC1A(excDC1A).then( res => {
                this.props.history.push('/excDC1As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excDC1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcDC1A</h3>
        }else{
            return <h3 className="text-center">Update ExcDC1A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcDC1A}>Save</button>
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

export default CreateExcDC1AComponent
