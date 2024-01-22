import React, { Component } from 'react'
import ExcDC3AService from '../services/ExcDC3AService';

class CreateExcDC3AComponent extends Component {
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
            ExcDC3AService.getExcDC3AById(this.state.id).then( (res) =>{
                let excDC3A = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcDC3A = (e) => {
        e.preventDefault();
        let excDC3A = {
                excDC3AId: this.state.id,
            };
        console.log('excDC3A => ' + JSON.stringify(excDC3A));

        // step 5
        if(this.state.id === '_add'){
            excDC3A.excDC3AId=''
            ExcDC3AService.createExcDC3A(excDC3A).then(res =>{
                this.props.history.push('/excDC3As');
            });
        }else{
            ExcDC3AService.updateExcDC3A(excDC3A).then( res => {
                this.props.history.push('/excDC3As');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excDC3As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcDC3A</h3>
        }else{
            return <h3 className="text-center">Update ExcDC3A</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcDC3A}>Save</button>
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

export default CreateExcDC3AComponent
