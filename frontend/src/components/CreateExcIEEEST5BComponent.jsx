import React, { Component } from 'react'
import ExcIEEEST5BService from '../services/ExcIEEEST5BService';

class CreateExcIEEEST5BComponent extends Component {
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
            ExcIEEEST5BService.getExcIEEEST5BById(this.state.id).then( (res) =>{
                let excIEEEST5B = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST5B = (e) => {
        e.preventDefault();
        let excIEEEST5B = {
                excIEEEST5BId: this.state.id,
            };
        console.log('excIEEEST5B => ' + JSON.stringify(excIEEEST5B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST5B.excIEEEST5BId=''
            ExcIEEEST5BService.createExcIEEEST5B(excIEEEST5B).then(res =>{
                this.props.history.push('/excIEEEST5Bs');
            });
        }else{
            ExcIEEEST5BService.updateExcIEEEST5B(excIEEEST5B).then( res => {
                this.props.history.push('/excIEEEST5Bs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/excIEEEST5Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST5B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST5B</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST5B}>Save</button>
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

export default CreateExcIEEEST5BComponent
