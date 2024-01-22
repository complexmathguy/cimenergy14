import React, { Component } from 'react'
import ExcIEEEST1AService from '../services/ExcIEEEST1AService';

class CreateExcIEEEST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                uelin: ''
        }
        this.changeUelinHandler = this.changeUelinHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEST1AService.getExcIEEEST1AById(this.state.id).then( (res) =>{
                let excIEEEST1A = res.data;
                this.setState({
                    uelin: excIEEEST1A.uelin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST1A = (e) => {
        e.preventDefault();
        let excIEEEST1A = {
                excIEEEST1AId: this.state.id,
                uelin: this.state.uelin
            };
        console.log('excIEEEST1A => ' + JSON.stringify(excIEEEST1A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST1A.excIEEEST1AId=''
            ExcIEEEST1AService.createExcIEEEST1A(excIEEEST1A).then(res =>{
                this.props.history.push('/excIEEEST1As');
            });
        }else{
            ExcIEEEST1AService.updateExcIEEEST1A(excIEEEST1A).then( res => {
                this.props.history.push('/excIEEEST1As');
            });
        }
    }
    
    changeUelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST1A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST1A</h3>
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
                                            <label> Uelin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST1A}>Save</button>
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

export default CreateExcIEEEST1AComponent
