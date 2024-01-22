import React, { Component } from 'react'
import ExcIEEEST6BService from '../services/ExcIEEEST6BService';

class CreateExcIEEEST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                oelin: ''
        }
        this.changeOelinHandler = this.changeOelinHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEST6BService.getExcIEEEST6BById(this.state.id).then( (res) =>{
                let excIEEEST6B = res.data;
                this.setState({
                    oelin: excIEEEST6B.oelin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST6B = (e) => {
        e.preventDefault();
        let excIEEEST6B = {
                excIEEEST6BId: this.state.id,
                oelin: this.state.oelin
            };
        console.log('excIEEEST6B => ' + JSON.stringify(excIEEEST6B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST6B.excIEEEST6BId=''
            ExcIEEEST6BService.createExcIEEEST6B(excIEEEST6B).then(res =>{
                this.props.history.push('/excIEEEST6Bs');
            });
        }else{
            ExcIEEEST6BService.updateExcIEEEST6B(excIEEEST6B).then( res => {
                this.props.history.push('/excIEEEST6Bs');
            });
        }
    }
    
    changeOelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST6Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST6B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST6B</h3>
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
                                            <label> Oelin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST6B}>Save</button>
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

export default CreateExcIEEEST6BComponent
